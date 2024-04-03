package com.map.hibernateObjectStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.ProjectWithMaven.Certificate;
import com.tut.ProjectWithMaven.Student;

public class ObjectStateDemo {

	public static void main(String[] args) {
//
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		SessionFactory factory = cfg.buildSessionFactory();

		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// Creating student object

		Student student = new Student();
		student.setId(1);
		student.setName("Ketan");
		student.setCity("Surat");
		student.setCerti(new Certificate("AWS Course", "3 months"));
		// student:transient state-> student is in transient state

		Session session = f.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		// student:Persistent state- Object is associated with session and database both

		// SO, as we are in Persistence state when value in setter is changed inobject
		// similar it will be reflected in table,first insert with Ketan will be done
		// than update with Peter will be done so finally it will be peter in
		// table.Check console first insert than update
		student.setName("Peter");
		tx.commit();

		session.close();
		// now after close session student:Detach state
		//Here Peter will be saved in DB-table and not 

		student.setName("John");
		System.out.println(student);
		
		//For removed state: To remove value from database by keep in session(means keep associated with session)
		//Take value from database and delete and than use it is called remove state

		f.close();
	}

}
