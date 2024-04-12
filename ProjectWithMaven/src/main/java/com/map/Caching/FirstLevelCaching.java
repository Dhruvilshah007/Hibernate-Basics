package com.map.Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.ProjectWithMaven.Student;

public class FirstLevelCaching {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();

		// by default enabled, Cache range will be still session is not closed

		Student student = session.get(Student.class, 1);

		System.out.println(student);

		System.out.println("Other working code");
		//Here when student get() is done hibernate will store id:1 student in its cache.so,when we again try to get() same id:1 student it will retrieve from cache and wont make DB call
		

		
		Student student1 = session.get(Student.class, 1);
		
		//To check if any object is present in cache or not,below will return true as it is present in cache
		
		System.out.println(session.contains(student1));

		System.out.println(student1);


		session.close();
		
		//it will throw exception ->Exception in thread "main" java.lang.IllegalStateException: Session/EntityManager is closed
		System.out.println(session.contains(student1));

	}

}
