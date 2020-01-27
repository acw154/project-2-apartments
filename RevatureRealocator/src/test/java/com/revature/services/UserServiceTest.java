package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.models.UserStatus;
import com.revature.repositories.UserDAOImpl;
import com.revature.repositories.UserStatusDAOImpl;

public class UserServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	UserDAOImpl uDAOMock = mock(UserDAOImpl.class);
	UserStatusDAOImpl ustatDAOMock = mock(UserStatusDAOImpl.class);
	UserService uService = new UserService(uDAOMock, ustatDAOMock);
	
	@Test
	public void testFindByEmail() {
		UserStatus status = new UserStatus("not looking");
		User user = new User(1, "TestPass", "Firstname", "Lastname", "Testmail@mail.com", null, "VA", status);
		when(uDAOMock.getUserByEmail("TestPass")).thenReturn(user);
		assertEquals(user, uService.findByEmail("TestPass"));
	}

	@Test
	public void testUpsertGood() {
		UserStatus status = new UserStatus("not looking");
		User user = new User(1, "TestPass", "Firstname", "Lastname", "Testmail@mail.com", null, "VA", status);
		when(ustatDAOMock.getStatusByString("not looking")).thenReturn(status);
		when(uDAOMock.getUserByEmail("Testmail@mail.com")).thenReturn(user);
		assertEquals(user, uService.upsert(user));
		
	}
	
	@Test
	public void testUpsertFail() {
		UserStatus status = new UserStatus("not looking");
		User user = new User(1, "TestPass", "Firstname", "Lastname", "Testmail@mail.com", null, "VA", status);
		User user2 = new User(0, "TestPass", "Firstname", "Lastname", "Testmail@mail.com", null, "VA", status);
		when(ustatDAOMock.getStatusByString("not looking")).thenReturn(status);
		when(uDAOMock.getUserByEmail("Testmail@mail.com")).thenReturn(user2);
		assertNull(uService.upsert(user));
		
	}

	@Test
	public void testVerifyUserGood() {
		UserStatus status = new UserStatus("not looking");
		User user = new User(1, "TestPass", "Firstname", "Lastname", "Testmail@mail.com", null, "VA", status);
		when(uDAOMock.getUserByEmail("Testmail@mail.com")).thenReturn(user);
		assertTrue(uService.verifyUser(user.getEmail(), "TestPass"));
	}
	
	@Test
	public void testVerifyUserBad() {
		UserStatus status = new UserStatus("not looking");
		User user = new User(1, "TestPass", "Firstname", "Lastname", "Testmail@mail.com", null, "VA", status);
		when(uDAOMock.getUserByEmail("Testmail@mail.com")).thenReturn(user);
		assertFalse(uService.verifyUser("Testmail@mail.com", "TestPassWrong"));
	}
	
	@Test
	public void testVerifyUserNoExist() {
		UserStatus status = new UserStatus("not looking");
		User user = new User(1, "TestPass", "Firstname", "Lastname", "Testmail@mail.com", null, "VA", status);
		when(uDAOMock.getUserByEmail("NotAUser@mail.com")).thenReturn(null);
		assertFalse(uService.verifyUser("NotAUser@mail.com", "TestPass"));
	}

	@Test
	public void testFindByState() {
		UserStatus status = new UserStatus("not looking");
		User user = new User(1, "TestPass", "Firstname", "Lastname", "Testmail@mail.com", null, "VA", status);
		User user2 = new User(1, "TestPass", "Firstname2", "Lastname", "Testmail2@mail.com", null, "VA", status);
		User user3 = new User(1, "TestPass", "Firstname3", "Lastname", "Testmail3@mail.com", null, "VA", status);
		List<User> list = new ArrayList<>();
		List<UserDTO> dtolist = new ArrayList<>();
		list.add(user);
		list.add(user2);
		list.add(user3);
		for(User u : list) {
			dtolist.add(new UserDTO(u));
		}
		when(uDAOMock.findByState("VA")).thenReturn(list);
		assertEquals(uService.findByState("VA"), dtolist);
	}



}
