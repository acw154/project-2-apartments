package com.revature.repositories;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.models.UserStatus;


@SuppressWarnings({ "deprecation", "unchecked" })
@Repository
public class UserStatusDAOImpl implements UserStatusDAO {

	private static final Logger logger = LogManager.getLogger(UserStatusDAOImpl.class);
	@Autowired
	private SessionFactory sf;
	
	
	
	
	
	@Override
	@Transactional
	public UserStatus getStatusByString(String status) {
		// TODO Auto-generated method stub
		Session s = sf.getCurrentSession();
		UserStatus uStatus = null;
		try {
			Query query = s.createQuery("from UserStatus where status = '"
					+ status + "'", UserStatus.class);
			System.out.println(query);
			uStatus = (UserStatus) query.getResultList().get(0);
			logger.info("Returned userstatus of: " + uStatus);
			return uStatus;
		} catch (IndexOutOfBoundsException e) {
			logger.warn("Attempted to fetch UserStatus with a status of: " + status, e);
			e.printStackTrace();
		}
		return uStatus;
	}

}
