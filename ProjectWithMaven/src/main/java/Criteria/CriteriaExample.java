package Criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.ProjectWithMaven.Student;

public class CriteriaExample {

	public static void main(String[] args) {
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();

		Criteria c = session.createCriteria(Student.class);

		//c.add(Restrictions.eq("certi.course", "AWS Course"));
		//lt, isnul,like etc..
		c.add(Restrictions.gt("id", 3));
		c.add(Restrictions.ilike("name", "ke%"));

		List<Student> studentList = c.list();

		for (Student stud : studentList) {
			System.out.println(stud);
		}

		session.close();
	}

}
