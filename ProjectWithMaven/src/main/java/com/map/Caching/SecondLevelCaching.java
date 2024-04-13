package com.map.Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.ProjectWithMaven.Student;

public class SecondLevelCaching {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session1 = sessionFactory.openSession();
		// first
		Student student1 = session1.get(Student.class, 1);
		System.out.println(student1);

		session1.close();

		Session session2 = sessionFactory.openSession();
		// second
		Student student2 = session2.get(Student.class, 1);
		System.out.println(student2);

		// So here again we are getting student with id:1 and in console we will see
		// that no new DB call is made,means no query is present again for this session,
		// so we have implemented 2nd level cache

		session2.close();

	}

}
