package com.tut.ProjectWithMaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started");

		// for saving thread safe object
		// Here hibernate.cfg.xml file location is very important, if we change path,
		// than would be difficult to find path, if we specify whole path than its fine

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
//		cfg.configure("com/tut/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating student

		Student st = new Student();
		st.setId(2);
		st.setName("Raj");
		st.setCity("Surat");

//		System.out.println(st);

		// creating object of address class

		Address ad = new Address();
		ad.setStreet("1");
		ad.setCity("AHmedabad");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(132.1231);

		// reading image

		FileInputStream fis = new FileInputStream("src/main/java/20240317_103056.jpg");

		byte[] data = new byte[fis.available()];
		ad.setImage(data);

		// Session operations
		try (Session session = factory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.save(st);
			//session.save(ad);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("DONE");

//
//		Session session = factory.openSession();
//
//		Transaction tx = session.beginTransaction();
//		session.save(st);
//
//		tx.commit();
//
//		session.close();

//
//		// One liner
////		SessionFactory factory= new Configuration().configure().buildSessionFactory();
//		
//		System.out.println(factory);
//		
//		//factory is open or closed
//		System.out.println(factory.isClosed());
//		factory.close();
//		System.out.println(factory.isClosed());

	}
}
