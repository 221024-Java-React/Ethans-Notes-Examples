package com.example.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateConfig {
	
	private static SessionFactory factory = new Configuration()
			.setProperty("hibernate.connection.username", "postgres")
			.setProperty("hibernate.connection.password", "password")
			.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/smsorm")
			.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
			.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.PostgreSQLDialect")
			.setProperty("hibernate.show_sql", "false")
			.setProperty("hibernate.format_sql", "false")
			.setProperty("hibernate.hbm2ddl.auto", "update")
			.addAnnotatedClass(com.example.models.Person.class)
			.addAnnotatedClass(com.example.models.Course.class)
			.buildSessionFactory();
	
	
	private static Session ses;
	
	public static Session getSession() {
		if(ses == null) {
			ses = factory.openSession();
		}
		
		return ses;
	}
	
	public static void closeSes() {
		ses.close();
		factory.close();
	}


}
