package com.revature.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Preference;
import com.revature.models.Property;
import com.revature.models.PropertyType;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.models.UserStatus;
import com.revature.repositories.PropertyDAOImpl;
import com.revature.util.APIParse;
import com.revature.util.APIUtil;

public class PropertyServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	APIUtil apiMock = mock(APIUtil.class);
	APIParse parseMock = mock(APIParse.class);
	PropertyDAOImpl pdaoMock = mock(PropertyDAOImpl.class);
	PropertyTypeService ptsMock = mock(PropertyTypeService.class);
	UserService usMock = mock(UserService.class);
	PropertyService pService = new PropertyService(pdaoMock, ptsMock, usMock);
	
	

	

	@Test
	public void testFindByAddressNoApt() {
		PropertyType pType = new PropertyType("townhome");
		Property p = new Property(pType, 111, "Test St.", "Houston", 11223, "TX", 2, 2.5, "thisphoto.jpg", 1200, false, false, 1400, false);
		when(pdaoMock.findByAddressNoApt(111, "Test St.", "Houston", "TX")).thenReturn(p);
		assertEquals(p, pService.findByAddress(111, "Test St.", 0, "Houston", "TX"));
	}
	
	@Test
	public void testFindByAddressWithApt() {
		PropertyType pType = new PropertyType("townhome");
		Property p = new Property(pType, 111, "Test St.", "Houston", 11223, "TX", 201, 2, 2.5, "thisphoto.jpg", 1200, false, false, 1400, false);
		when(pdaoMock.findByAddressWithApt(111, "Test St.", 201, "Houston", "TX")).thenReturn(p);
		assertEquals(p, pService.findByAddress(111, "Test St.", 201, "Houston", "TX"));
	}

	@Test
	public void testUpsertWithAptGood() {
		PropertyType pType = new PropertyType("townhome");
		Property p = new Property(pType, 111, "Test St.", "Houston", 11223, "TX", 201, 2, 2.5, "thisphoto.jpg", 1200, false, false, 1400, false);
		when(ptsMock.findByType("townhome")).thenReturn(pType);
		when(pdaoMock.findByAddressWithApt(111, "Test St.", 201, "Houston", "TX")).thenReturn(p);
		assertTrue(pService.upsert(p));
	}
	
	@Test
	public void testUpsertWithAptBad() {
		PropertyType pType = new PropertyType("townhome");
		Property p = new Property(pType, 111, "Test St.", "Houston", 11223, "TX", 201, 2, 2.5, "thisphoto.jpg", 1200, false, false, 1400, false);
		Property p2 = new Property(pType, 123, "WrongTest St.", "Dallas", 11343, "TX", 201, 2, 2.5, "thisphoto.jpg", 1200, false, false, 1400, false);
		when(ptsMock.findByType("townhome")).thenReturn(pType);
		when(pdaoMock.findByAddressWithApt(111, "Test St.", 201, "Houston", "TX")).thenReturn(p2);
		assertFalse(pService.upsert(p));
	}
	
	@Test
	public void testUpsertNoAptGood() {
		PropertyType pType = new PropertyType("townhome");
		Property p = new Property(pType, 111, "Test St.", "Houston", 11223, "TX", 2, 2.5, "thisphoto.jpg", 1200, false, false, 1400, false);
		when(ptsMock.findByType("townhome")).thenReturn(pType);
		when(pdaoMock.findByAddressNoApt(111, "Test St.", "Houston", "TX")).thenReturn(p);
		assertTrue(pService.upsert(p));
	}

	




	@Test
	public void testAssociateUserAndProperty() {
		UserStatus status = new UserStatus("not looking");
		User user = new User("Pass", "Firstname", "Lastname", "mail@mail.com", null, "IL", null, status, null, null);
		PropertyType pType2 = new PropertyType("apartment");
		Property p = new Property(pType2, 111, "Test St.", "Chicago", 11223, "IL", 101, 2, 2.5, "thisphoto.jpg", 1200, false, false, 1400, false);
		when(usMock.findByEmail("mail@mail.com")).thenReturn(user);
		List<Property> list = new ArrayList<>();
		list.add(p);
		when(pdaoMock.findByAddressWithApt(111, "Test St.", 101, "Chicago", "IL")).thenReturn(p);
		when(pService.findByAddress(111, "Test St.", 101, "Chicago", "IL")).thenReturn(p);
		user.setSavedProperties(list);
		when(usMock.upsert(user)).thenReturn(user);
		UserDTO dto = new UserDTO(user);
		assertEquals(dto, pService.associateUserAndProperty(p, "mail@mail.com"));
		
		
	}

}
