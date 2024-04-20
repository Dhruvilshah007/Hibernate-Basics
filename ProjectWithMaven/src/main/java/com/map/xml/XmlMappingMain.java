package com.map.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class XmlMappingMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Person person = new Person(1, "dds", "Ahmedabad", "78923982");
		
		session.save(person);

		tx.commit();

		session.close();

		sessionFactory.close();

	}

}
