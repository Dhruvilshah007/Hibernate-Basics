package com.map.oneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemoOneToMany {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// ONE TO MANY
		// Post -1
//		Post post1 = new Post();
//		post1.setPostId(1);
//		post1.setPost("This post is related to Java and how good java is");
//
//		Comment comment1 = new Comment();
//		comment1.setCommentId(1);
//		comment1.setComment("Java is good but python is also good");
//		comment1.setPost(post1);
//
//		Comment comment2 = new Comment();
//		comment2.setCommentId(2);
//		comment2.setComment("I like Golang");
//		comment2.setPost(post1);
//
//		Comment comment3 = new Comment();
//		comment3.setCommentId(3);
//		comment3.setComment("I think Js is best");
//		comment3.setPost(post1);
//
//		List<Comment> commentList = new ArrayList<>();
//		commentList.add(comment1);
//		commentList.add(comment2);
//		commentList.add(comment3);
//
//		post1.setComments(commentList);

		// save

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

//		session.save(post1);
//		session.save(comment1);
//		session.save(comment2);
//		session.save(comment3);

		// fetch

		Post post = session.get(Post.class, 1);
		System.out.println(post.getPost());

		for (Comment comment : post.getComments()) {
			System.out.println(comment.getComment());
		}

		tx.commit();

		factory.close();

	}

}
