package com.revature.repositories;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Preference;
import com.revature.models.User;

@SuppressWarnings({ "deprecation", "unchecked" })
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sf;

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> findAll() {
		Session s = sf.getCurrentSession();
		return (List<User>) s.createCriteria(User.class).list();
	}

	@Override
	@Transactional
	public User findById(int id) {
		
		Session s = sf.getCurrentSession();
		
		return s.get(User.class, id);
	}

	@Override
	@Transactional
	public void save(User u) {
		
		Session s = sf.getCurrentSession();
		
		s.save(u);
	}
	
	@Override
	@Transactional
	public void upsertUser(User user) {
		Session s = sf.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(user);
		tx.commit();
	
	}
	
	
	
	
	@Override
	@Transactional
	public void update(User u) {
		
		Session s = sf.getCurrentSession();
		
		s.update(u);
	}

 

	@Override
	@Transactional
	public User getUserByEmail(String email) {
		Session s = sf.getCurrentSession();
		
		Query query = s.createQuery("from User where email = "
				+ email, User.class);
		
		User u = (User) query.getResultList().get(0);
		return u;
	}

	@Override
	@Transactional
	public User findByFirstLastName(String f_name, String l_name) {
		
		Session s = sf.getCurrentSession();
		
		Query query = s.createQuery("from User where first_name =:fname, last_name =:lname", User.class);
		
		query.setParameter(1, f_name);
		query.setParameter(2, l_name);
		
		User u = (User) query.getResultList().get(0);
		return u;
		
		
	}

	@Override
	@Transactional
	public List<User> findByState(String state) {
		Session s = sf.getCurrentSession();
		Query query = s.createQuery("from User where current_state=:state", User.class);
		query.setParameter(1, state);
		List<User> list = (List<User>) query.getResultList();
		return list;
	}

}
