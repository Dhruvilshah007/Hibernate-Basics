package com.map.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.ProjectWithMaven.Student;

public class HQLSelectExample {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		// HQL synatax

		// 1-It will get all Student data
		String query = "from Student";

		Query q = session.createQuery(query);

		// single result
//		q.uniqueResult();

		// multiple result
		List<Student> studentList = q.list();

		for (Student student : studentList) {
			System.out.println(student);

		}

		// 2-Get student where city is Ahmedabad
		
		System.out.println("Student city Filter");

		String cityQuery = "from Student where city=:c";
		
		Query cityQ = session.createQuery(cityQuery);
		cityQ.setParameter("c", "Ahmedabad");
		List<Student> studentListWithCity = cityQ.list();
		for (Student student : studentListWithCity) {
			System.out.println(student);

		}
		
		//3- We can also use alias
		

		System.out.println("Using Alias");

		String nameCityQuery = "from Student as stud where stud.city=:c and stud.name=:n";
		
		Query nameCityQ = session.createQuery(nameCityQuery);
		nameCityQ.setParameter("c", "Ahmedabad");
		nameCityQ.setParameter("n", "Ketan");
		List<Student> studentListWithNameCity = nameCityQ.list();
		for (Student student : studentListWithNameCity) {
			System.out.println(student);

		}
		
		session.close();

		factory.close();

	}
}
