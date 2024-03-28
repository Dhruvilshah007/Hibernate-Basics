package com.tut.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student1 = new Student();
		student1.setId(10);
		student1.setName("Kamlesh");
		student1.setCity("Mumbai");

		Certificate certificate = new Certificate();

		certificate.setCourse("JAVA");
		certificate.setDuration("2 months");

		student1.setCerti(certificate);

		Student student2 = new Student();
		student2.setId(12);
		student2.setName("Ravi");
		student2.setCity("Delhi");

		Certificate certificate2 = new Certificate();

		certificate2.setCourse("Python");
		certificate2.setDuration("1 month");

		student2.setCerti(certificate);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// objects save
		session.save(student1);
		session.save(student2);

		tx.commit();

		session.close();
		factory.close();
	}

}
