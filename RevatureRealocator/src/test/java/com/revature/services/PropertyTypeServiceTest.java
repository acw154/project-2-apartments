package com.revature.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.PropertyType;
import com.revature.repositories.PropertyTypeDAOImpl;

public class PropertyTypeServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	PropertyTypeDAOImpl pdaoMock = mock(PropertyTypeDAOImpl.class);
	PropertyTypeService pService = new PropertyTypeService(pdaoMock);
	
	




	@Test
	public void testFindByType() {
		PropertyType pType = new PropertyType(1, "condo");
		String type = "condo";
		when(pdaoMock.findByType(type)).thenReturn(pType);
		assertEquals(pType, pService.findByType("condo"));
	}

}
