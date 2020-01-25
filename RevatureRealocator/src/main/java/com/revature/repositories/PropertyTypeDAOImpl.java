package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.PropertyType;

@SuppressWarnings({"unchecked", "deprecation"})
@Repository
public class PropertyTypeDAOImpl implements PropertyTypeDAO {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public List<PropertyType> findAll() {
		Session s = sf.getCurrentSession();
		return (List<PropertyType>) s.createQuery("FROM PropertyType").list();
		
	}

	@Override
	@Transactional
	public void upsert(PropertyType pt) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(pt);

	}

	@Override
	@Transactional
	public void delete(PropertyType pt) {
		Session s = sf.getCurrentSession();
		s.delete(pt);

	}

	@Override
	@Transactional
	public PropertyType findById(int id) {
		Session s = sf.getCurrentSession();
		Query<PropertyType> query = s.createQuery("FROM PropertyType WHERE id=:i");
		query.setParameter(1, id);
		return query.getResultList().get(0);
	}

	@Override
	@Transactional
	public PropertyType findByType(String type) {
		Session s = sf.getCurrentSession();
		Query<PropertyType> query = s.createQuery("FROM PropertyType WHERE type = '" + type + "'");
		System.out.println(query.getResultList());
		return query.getResultList().get(0);
	}

}
