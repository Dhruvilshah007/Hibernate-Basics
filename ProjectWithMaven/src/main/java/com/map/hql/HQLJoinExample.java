package com.map.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class HQLJoinExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		// For updating we will require Transaction
		Transaction tx = session.beginTransaction();

		// from Question as q or from Question q
		Query q = session
				.createQuery("select p.post,p.postId,c.comment from Post p INNER JOIN p.comments as c");

		// q.list() or q.getResultList();
		// list() is specific to Hibernate's Query interface, while getResultList() is
		// specific to JPA's Query interface. They serve the same purpose but belong to
		// different technologies
		List<Object[]> studentList = q.getResultList();

		for (Object[] arr : studentList) {
			System.out.println(Arrays.toString(arr));
		}
		tx.commit();
		session.close();

		factory.close();
	}

}
