package com.revature.repositories;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Preference;
import com.revature.models.User;


@Repository
public class PreferencesDAOImpl implements PreferencesDAO {

	private static final Logger logger = LogManager.getLogger(PreferencesDAOImpl.class);
	@Autowired
	private SessionFactory sf;
	
	
	@Override
	@Transactional
	public Preference getPreferenceByUserId(int userid) {
		Session s = sf.getCurrentSession();
		Preference p = null;
		try {
			Query<Preference> query = s.createQuery("from Preference where user_id = '"
					+ userid + "'", Preference.class);
			p = query.getResultList().get(0);
			return p;
		} catch (IndexOutOfBoundsException e) {
			logger.warn("Attempted to find Preference with UserId: " + userid, e);
			
		}
		return p;
	}


	@Override
	@Transactional
	public void upsertPreference(Preference preference) {
		Session s = sf.getCurrentSession();
		//Transaction tx = s.getTransaction();
		s.saveOrUpdate(preference);
		//tx.commit();
	
	}

	
	@Override
	public void deletePreference(Preference preference) {
		Session s = sf.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(preference);
		tx.commit();
	}


	@Override
	public Preference getPreferenceByPreferenceId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
