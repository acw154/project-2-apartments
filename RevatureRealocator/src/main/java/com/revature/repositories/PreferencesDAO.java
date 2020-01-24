package com.revature.repositories;

import com.revature.models.Preference;
import com.revature.models.User;

public interface PreferencesDAO {

	
	public Preference getPreferenceByPreferenceId(int id);
	
	public void upsertPreference(Preference preference);
	
	public void deletePreference(Preference preference);

	Preference getPreferenceByUserId(int userid);
	
}
