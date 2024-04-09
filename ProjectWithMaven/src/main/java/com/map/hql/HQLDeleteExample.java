package com.map.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.ProjectWithMaven.Student;

public class HQLDeleteExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		// For deleting we will require Transaction
		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("delete from Student s where s.city=:c");
		q.setParameter("c", "Goa");
		
		//studentList will have number of rows deleted
		int studentList = q.executeUpdate();

		System.out.println("Deleted count->" + studentList);
		tx.commit();
		session.close();

		factory.close();
	}

}
