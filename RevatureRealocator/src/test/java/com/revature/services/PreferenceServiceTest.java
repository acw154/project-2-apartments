package com.revature.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Preference;
import com.revature.models.User;
import com.revature.models.UserStatus;
import com.revature.repositories.PreferencesDAOImpl;

public class PreferenceServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	UserService usMock = mock(UserService.class);
	PreferencesDAOImpl pdaoMock = mock(PreferencesDAOImpl.class);
	PreferenceService pService = new PreferenceService(pdaoMock, usMock);

	@Test
	public void testFindByEmail() {
		UserStatus status = new UserStatus("not looking");
		User user = new User("Pass", "Firstname", "Lastname", "mail@mail.com", null, "IL", null, status, null, null);
		user.setId(7);
		Preference pref = new Preference(true, 0, 1200, 1, 1, false, "Richmond", "VA", user);
		when(usMock.findByEmail("mail@mail.com")).thenReturn(user);
		when(pdaoMock.getPreferenceByUserId(7)).thenReturn(pref);
		assertEquals(pref, pService.findByEmail("mail@mail.com"));
		
	}

	@Test
	public void testUpsert() {
		UserStatus status = new UserStatus("not looking");
		User user = new User("Pass", "Firstname", "Lastname", "mail@mail.com", null, "IL", null, status, null, null);
		user.setId(7);
		Preference pref = new Preference(true, 0, 1200, 1, 1, false, "Richmond", "VA", user);
		user.setPreference(pref);
		when(usMock.findByEmail("mail@mail.com")).thenReturn(user);
		//when(pdaoMock.upsertPreference(pref))
		when(pdaoMock.getPreferenceByUserId(7)).thenReturn(pref);
		assertEquals(pref, pService.upsert(pref, "mail@mail.com"));
		
		
		
		
	}

}
