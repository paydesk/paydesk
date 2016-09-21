package com.paydesk.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.paydesk.data.UserRole;

 
@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login() {
		System.out.println("in login controller");
		testApp();
		return "login";
	}
	
	/**
	 * Just Testing the use of Hibernate and PostGresSQL 
	 */
	public void testApp() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserRole user = new UserRole("firstuser");
		session.save(user);

		session.getTransaction().commit();
		session.close();
	}
}