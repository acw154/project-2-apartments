package com.revature.repositories;

import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	
	private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);
	@Autowired
	private SessionFactory sf;


	
	@Override
	@Transactional
	public void upsertUser(User user) {
		System.out.println("User object user is: " + user);
		System.out.println("inside upsertUser method UserDAO");
		Session s = sf.getCurrentSession();
		System.out.println("got session, beginning transaction");
		//Transaction tx = s.beginTransaction();
		//Transaction tx = s.getTransaction();
		//Transaction tx = s.
		System.out.println("transaction.beginTransaction method successful, starting try block");
		try {
			System.out.println("inside try block");
			//s.save(user);
			s.saveOrUpdate(user);
			System.out.println("just ran saveOrUpdate(user), about to run tx.commit()");
			//tx.commit();
			logger.info("Successful User upsert with email: " + user.getEmail());	
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Attempted user upsert with email: " + user.getEmail(), e);
		}
	
	}
	
	
	
	
	

 

	@Override
	@Transactional
	public User getUserByEmail(String email) {
		Session s = sf.getCurrentSession();
		User u = null;
		try {
			Query query = s.createQuery("from User where email = '"
					+ email + "'", User.class);
			System.out.println(query);
			u = (User) query.getResultList().get(0);
			logger.info("Found User with email: " + email);	
			return u;
		} catch (IndexOutOfBoundsException e) {
			logger.warn("Attempted to find User with email: " + email, e);
		}
		return u;
	}


	
	
	@Override
	@Transactional
	public List<User> findByState(String state) {
		Session ses = sf.getCurrentSession();
		System.out.println("state searching is: " + state);
		List<User> userList = ses.createQuery("from User where current_state='"
				+state+"'", User.class).list();

		System.out.println("Something running here.");
		System.out.println(userList);
		if(userList.size()==0) {
			return null;
		}
		return userList;

	}
	/**/
}
