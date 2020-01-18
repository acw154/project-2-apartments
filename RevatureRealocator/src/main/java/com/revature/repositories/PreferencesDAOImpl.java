package com.revature.repositories;

import javax.transaction.Transactional;

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

	
	@Autowired
	private SessionFactory sf;
	
	
	@Override
	@Transactional
	public Preference getPreferenceByPreferenceId(int id) {
		Session s = sf.getCurrentSession();
		
		Query<Preference> query = s.createQuery("from Preference where id = "
				+ id, Preference.class);
		Preference p = query.getResultList().get(0);
		return p;
		
	}


	@Override
	public void upsertPreference(Preference preference) {
		Session s = sf.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(preference);
		tx.commit();
	
	}

	
	@Override
	public void deletePreference(Preference preference) {
		Session s = sf.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(preference);
		tx.commit();
	}


}
