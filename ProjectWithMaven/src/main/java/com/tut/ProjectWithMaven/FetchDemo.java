package com.tut.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {

		// get,load
		// Transaction is only require when we need to save Data

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		
		
		//Basic example
		// get- student:1
		
//		Student student = session.get(Student.class, 2);
//		Address address = session.load(Address.class, 1);
//		
//		System.out.println(student);
//		System.out.println(address);
//		
		
		//case 1: How caching is done here for get()
		
//		Student student = session.get(Student.class, 1);
//		System.out.println(student);
//		
//		Student student2 = session.get(Student.class, 1);
//		System.out.println(student2);
		
		//Explanation: In console you will see that only once select query is executed ,so in 2nd time it is getting data from cache
		
		
		//case 2: Select Query executed after student object is printed
		
//		Student student = session.load(Student.class, 1);
//		System.out.println(student);
		
		//Explanation: In console you will see that when sysout is commented than no sql query is executed in console, when it is uncommented than sql call is 						done
		
		//case 3 : load() also has cache and it will also get from cache if same data is getted
		
		Student student = session.load(Student.class, 1);
		System.out.println(student);
		
		Student student2 = session.load(Student.class, 1);
		System.out.println(student2);
		
		
		Session session2 = factory.openSession();
		
		Student student3 = session2.load(Student.class, 1);
		System.out.println(student3);
		
		//Explanation : So here therewill be 2 database hits as thereare 2 different sessions,
		// In first hit data will be saved in cache of first session
		// In secondhot data will be provided from first session cache.(first level cache)
		// In third
		
		
		session.close();
		factory.close();

	}

}
