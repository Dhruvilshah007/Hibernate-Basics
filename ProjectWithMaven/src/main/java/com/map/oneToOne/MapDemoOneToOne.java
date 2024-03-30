package com.map.oneToOne;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemoOneToOne {

	// uni and bidirectional in one to one

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// ONE TO ONE

		// creating Question 1

		Question q1 = new Question();
		q1.setQuestionId(1);
		q1.setQuestion("What is Java??");

		Answer answer = new Answer();
		answer.setAnswerId(1);
		answer.setAnswer("Java is Programming language");
		answer.setQuestion(q1);

		q1.setAnswer(answer);

		// creating Question 1

		Question q2 = new Question();
		q2.setQuestionId(2);
		q2.setQuestion("What is API??");

		Answer answer2 = new Answer();
		answer2.setAnswerId(2);
		answer2.setAnswer("API is Application Programming Interface");
		answer2.setQuestion(q2);

		q2.setAnswer(answer2);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(q1);
		session.save(q2);
		session.save(answer);
		session.save(answer2);

		tx.commit();

		// fetching,here 1 is QuestionId

		Question question = session.get(Question.class, 1);
		System.out.println(question.getQuestion());
		System.out.println(question.getAnswer().getAnswer());

		factory.close();

	}

}
