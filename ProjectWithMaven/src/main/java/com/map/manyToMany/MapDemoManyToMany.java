package com.map.manyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemoManyToMany {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Emp e1 = new Emp();
		Emp e2 = new Emp();

		e1.setEid(1);
		e1.setName("Dhruvil");

		e2.setEid(2);
		e2.setName("Ram");

		Project p1 = new Project();
		Project p2 = new Project();

		p1.setPid(1);
		p1.setProjectName("Library Mgmt System");

		p2.setPid(2);
		p2.setProjectName("Ecomm Project");

		List<Emp> empList = new ArrayList<>();
		List<Project> projectList = new ArrayList<>();

		empList.add(e1);
		empList.add(e2);

		projectList.add(p1);
		projectList.add(p2);

		e1.setProjects(projectList);
		p2.setEmps(empList);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		tx.commit();

		session.close();

		factory.close();

	}

}
