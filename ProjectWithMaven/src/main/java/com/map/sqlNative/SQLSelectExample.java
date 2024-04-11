package com.map.sqlNative;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.tut.ProjectWithMaven.Student;

public class SQLSelectExample {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		// SQL Queries

		// 1-It will get all Student data
		String query = "SELECT * from Student";

		// here return type can be both Query query` and NativeQuery nq
		NativeQuery nq = session.createSQLQuery(query);

		// single result
//		q.uniqueResult();

		// multiple result
		// here in Raw/Native SQL it wont return Student object like Hql, rather it will
		// return Object
		List<Object[]> studentList = nq.list();

		for (Object[] student : studentList) {
			System.out.println(Arrays.toString(student));

		}

		for (Object[] student : studentList) {
			System.out.println("Name: " + student[4] + " and City: " + student[3]);

		}

		session.close();

		factory.close();

	}
}
