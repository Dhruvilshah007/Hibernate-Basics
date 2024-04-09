package com.map.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLUpdateExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		// For updating we will require Transaction
		Transaction tx = session.beginTransaction();
		
//		Query q = session.createQuery("update Student set city=:newcity where name=:n");
		Query q = session.createQuery("update Student as stud set stud.city=:newcity where stud.name=:n");
		q.setParameter("newcity", "Kannur");
		q.setParameter("n", "Peter");
		
		int studentList = q.executeUpdate();

		System.out.println("Update count->" + studentList);
		tx.commit();
		session.close();

		factory.close();
	}

}
