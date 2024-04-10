package com.map.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.ProjectWithMaven.Student;

public class PaginationDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		// alternative
		// Query<Student> query = session.createQuery("from Student", Student.class);
		Query query = session.createQuery("from Student");

		
		// implementing pagination-CHeck SQL in console in it uses LIMIT
		// start from which index
		query.setFirstResult(2);

		// end at which index
		query.setMaxResults(4);

		List<Student> studentList = query.list();
		
		for (Student student : studentList) {
			System.out.println(student);
		}

		session.close();
		factory.close();
	}

}
