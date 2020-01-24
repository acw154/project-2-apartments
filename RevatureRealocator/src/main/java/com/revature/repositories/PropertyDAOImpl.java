package com.revature.repositories;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Preference;
import com.revature.models.Property;

@SuppressWarnings({"unchecked", "deprecation"})
@Repository
public class PropertyDAOImpl implements PropertyDAO {
	
	private static final Logger logger = LogManager.getLogger(PropertyDAOImpl.class);
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public List<Property> findAll() {
		Session s = sf.getCurrentSession();
		return (List<Property>) s.createQuery("FROM Property").list();
	}

	@Override
	@Transactional
	public Property findById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(Property.class, id);
	}

	@Override
	@Transactional
	public Property findByAddressWithApt(int street_num, String street, int apt_num, String city, String state) {
		Session s = sf.getCurrentSession();
		Query<Property> query = (Query<Property>) s.createQuery("FROM Property WHERE street_num=:n, apt_num=:a, city=:c, state=:s");
		query.setParameter(1, street_num);
		query.setParameter(2, street);
		query.setParameter(3, apt_num);
		query.setParameter(4, city);
		query.setParameter(5, state);
		List<Property> list = query.getResultList();
		if(list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	@Transactional
	public void upsert(Property p) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(p);
	}

	
	@Override
	@Transactional
	public List<Property> getPropertiesByUserId(int user_id) {
		Session s = sf.getCurrentSession();
		Query<Property> query = (Query<Property>) s.createQuery("FROM Property prop JOIN User u WHERE prop.property_id"
				+ " = u.property_id WHERE u.user_id = :id");
		query.setParameter(1, user_id);
		List<Property> list = query.getResultList();
		if(list.isEmpty()) {
			return null;
		}
		return list;
	}

	@Override
	@Transactional
	public void delete(Property p) {
		Session s = sf.getCurrentSession();
		s.delete(p);
	}


	@Override
	@Transactional
	public List<Property> findPropertiesByFilter(Preference pref) {
		Session s = sf.getCurrentSession();
		Query<Property> query = (Query<Property>) s.createQuery("FROM Property p WHERE p.num_beds=:beds, p.num_baths=:baths, "
				+ "p.price between :p1 and :p2, p.city=:c, p.pets=:pets, p.furnished=:f, p.state=:sc");
		query.setParameter(1, pref.getNumBeds());
		query.setParameter(2, pref.getNumBaths());
		query.setParameter(3, pref.getMinPrice());
		query.setParameter(4, pref.getMaxPrice());
		query.setParameter(5, pref.getCity());
		query.setParameter(6, pref.isPets());
		query.setParameter(7, pref.isFurnished());
		query.setParameter(8, pref.getState_code());
		List<Property> list = query.getResultList();
		if(list.isEmpty()) {
			return null;
		}
		return list;
	}

	@Override
	public Property findByAddressNoApt(int street_num, String street, String city, String state) {
		//Session s = sf.getCurrentSession();
		Session s = sf.openSession();
		
		Property p = null;
		try {
			Query<Property> query = (Query<Property>) s.createQuery("FROM Property WHERE street_num = '" +street_num + "' AND street = '" + street + "' AND city = '" + 
			city + "' AND state = '" + state + "'", Property.class);
			 p = query.getResultList().get(0);
		} catch (IndexOutOfBoundsException e) {
			logger.warn("Failed attempted to find Address with by: " + street_num + " " + street + " " + city + ", " + state, e);
			e.printStackTrace();
		}
		return p;
	}
	
	@Override
	public List<Property> findByStateNoApt(String state) {
		//Session s = sf.getCurrentSession();
		Session s = sf.openSession();
		
		List<Property> list = null;
		try {
			list = s.createQuery("FROM Property WHERE state = '" + state + "'", Property.class).list();
		} catch (IndexOutOfBoundsException e) {
			logger.warn("Failed attempted to find by State: " + state, e);
			e.printStackTrace();
		}
		if(list.size()==0) {
			return null;
		}
		return list;
	}
	
}
