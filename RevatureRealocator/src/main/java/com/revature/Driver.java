package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;

public class Driver {

	public static void main(String[] args) {

			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			IUserDAO dao = (IUserDAO) ac.getBean("userDAO");

		}
}
