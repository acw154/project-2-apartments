package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Property;
import com.revature.models.PropertyType;

public class APIParse {

	public static List<Property> parse(String data) {
		// set up
		System.out.println("Received data: \n" + data);
		List<Property> properties = new ArrayList<>();
		PropertyType pType1 = new PropertyType();
		pType1.setId(1);
		pType1.setType("single_family");
		PropertyType pType2 = new PropertyType();
		pType2.setId(2);
		pType2.setType("townhome");
		PropertyType pType3 = new PropertyType();
		pType3.setId(3);
		pType3.setType("apartment");
		PropertyType pType4 = new PropertyType();
		pType4.setId(4);
		pType4.setType("condo");
		String[] sa = data.split("\"listings\"");
		System.out.println("sa[0]: " + sa[0]);
		System.out.println("sa[1]: " + sa[1]);
		data = sa[1];
		int index;
		//int index = data.indexOf("0:", 0);
		//data = data.substring(index);
		sa = data.split("\\{");
		for(int i = 0; i < sa.length; i++) {
		}
		for(int i = 1; i < sa.length; i++) {
			Property p = new Property();
			String[] sa2 = sa[i].split("\"");
			for(int j = 0; j < sa2.length; j++) {
				if(sa2[j].equals("prop_type")) {
					if(sa2[j+2].equals(pType1.getType())) {
						p.setPropertyType(pType1);
					} else if(sa2[j+2].equals(pType2.getType())) {
						p.setPropertyType(pType2);
					} else if(sa2[j+2].equals(pType3.getType())) {
						p.setPropertyType(pType3);
					} else if(sa2[j+2].equals(pType4.getType())) {
						p.setPropertyType(pType4);
					} 
				}
				try {
					if(sa2[j].equals("address")) {
						System.out.println(sa2[j+2]);
						// need to iterate over the whole address here 
						if((p.getPropertyType().getType().equals("apartment")) || (p.getPropertyType().getType().equals("condo"))) {
							//iterate over address string if apartment
							
							//first is the street number
							index = sa2[j+2].indexOf(" ");
							String streetNo = new String();
							for(int k = 0; k < index; k++) {
								streetNo += sa2[j+2].charAt(k);
							}
							if(streetNo.contains("-")) {
								streetNo = streetNo.split("-")[0];
							}
							int streetNum = Integer.parseInt(streetNo);
							
							p.setStreet_num(streetNum);
							// second is street name
							if(sa2[j+2].contains("Apt")) {
								int index2 = sa2[j+2].indexOf("Apt");
								String streetName = sa2[j+2].substring((index + 1), (index2 - 1));
								p.setStreet(streetName);
								// third is apartment number
								int index3 = sa2[j+2].indexOf(",");
								int apartmentNum = Integer.parseInt(sa2[j+2].substring((index2 + 4), (index3)));
								p.setApt_num(apartmentNum);
								// fourth is to get the city
								String[] sa3 = sa2[j+2].split(",");
								String city = sa3[1];
								city = city.replace(" ", "");
								p.setCity(city);
								// fifth is to get the zip
								String zipString = sa3[2];
								zipString = zipString.replace(" ", "");
								int zip = Integer.parseInt(zipString);
								p.setZip(zip);
							} else {
								int index2 = sa2[j+2].indexOf(",");
								String streetName = sa2[j+2].substring((index + 1), (index2));
								p.setStreet(streetName);
								// third is apartment number
								/*
								 * int index3 = sa2[j+2].indexOf(","); int apartmentNum =
								 * Integer.parseInt(sa2[j+2].substring((index2 + 4), (index3)));
								 * p.setApt_num(apartmentNum);
								 */
								// fourth is to get the city
								String[] sa3 = sa2[j+2].split(",");
								String city = sa3[1];
								city = city.replace(" ", "");
								p.setCity(city);
								// fifth is to get the zip
								String zipString = sa3[2];
								zipString = zipString.replace(" ", "");
								int zip = Integer.parseInt(zipString);
								p.setZip(zip);
							}
							
							
							
						} else {
							// iterate over address string for no apt. num
							// first is street num
							index = sa2[j+2].indexOf(" ");
							String streetNo = new String();
							for(int k = 0; k < index; k++) {
								streetNo += sa2[j+2].charAt(k);
							}
							int streetNum = Integer.parseInt(streetNo);
							p.setStreet_num(streetNum);
							// second is street name
							int index2 = sa2[j+2].indexOf(",");
							String streetName = sa2[j+2].substring((index + 1), (index2));
							p.setStreet(streetName);
							// third is to get the city
							String[] sa3 = sa2[j+2].split(",");
							String city = sa3[1];
							city = city.replace(" ", "");
							p.setCity(city);
							// fourth is to get the zip
							String zipString = sa3[2];
							zipString = zipString.replace(" ", "");
							int zip = Integer.parseInt(zipString);
							p.setZip(zip);
							
						}
					}
				} catch (NumberFormatException e) {
					p.setApt_num(0);
					p.setCity(null);
					p.setState(null);
					p.setStreet(null);
					p.setStreet_num(0);
					p.setZip(0);
					e.printStackTrace();
				}
				if(sa2[j].equals("beds")) {
			
					String beds = sa2[j+2];
					int k = beds.length();
		
//			
					int realbeds = k-1;

					char bedsIntChar = beds.charAt(realbeds); 
					try {
						double bedsInt = Double.parseDouble(Character.toString(bedsIntChar));
						p.setNum_beds(bedsInt);
					} catch (NumberFormatException e) {
						p.setNum_beds(0);
						e.printStackTrace();
					}
				}
				if(sa2[j].equals("baths")) {
					//int baths = Integer.parseInt(sa2[j+2]);
					String baths = sa2[j+2];
					int k = (baths.length()-1);
					char bathsIntChar = baths.charAt(k);
					try {
						double bathsInt = Double.parseDouble(Character.toString(bathsIntChar));
						
						p.setNum_baths(bathsInt);
					} catch (NumberFormatException e) {
						p.setNum_baths(0);
						e.printStackTrace();
					}
				}
				if(sa2[j].equals("photo")) {
					String photoURL = sa2[j+2];
					p.setPhoto(photoURL);
				}
				if(sa2[j].equals("sqft_raw")) {
					String sqf = sa2[j+1].replace(":", "");
					sqf = sqf.replace(",", "");
					double sqft = Double.parseDouble(sqf);
					p.setSq_ft(sqft);
				}
				if(sa2[j].equals("pet_policy")) {
					if(sa2[j+2].contains("OK")) {
						p.setPets(true);
					}
				}
				if(sa2[j].equals("price_raw")) {
					String priceS = sa2[j+1].replace(":", "");
					System.out.println(priceS);
					priceS = priceS.replace(",", "");
					
					System.out.println(priceS);
					double price = Double.parseDouble(priceS);
					p.setPrice(price);
				}
			}
			properties.add(p);
		}
		return properties;
	}
	
}
