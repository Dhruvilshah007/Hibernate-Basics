package com.map.Cascading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.oneToMany.Comment;
import com.map.oneToMany.Post;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class CascadeExample {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();

		Post post1 = new Post();
		post1.setPostId(101);
		post1.setPost("101-Casading is very imp concept");

		Comment comment1 = new Comment(100, "cascase 101-It is True.", post1);
		Comment comment2 = new Comment(101, "cascase 101-I Agree", post1);
		Comment comment3 = new Comment(102, "cascase 101-I dont think is Imp", post1);

		List<Comment> commentList = new ArrayList<>();

		commentList.add(comment1);
		commentList.add(comment2);
		commentList.add(comment3);

		post1.setComments(commentList);

		Transaction tx = session.beginTransaction();

		// So, here only Post will be saved in Table of Post, while comment wont be
		// saved, we will require to do manually session.save(comment1) to save commenst
		// in COMMENT table
		// Here , we can use CASCADE here so automaticially save comment- check below
		// code add follwing->cascade = CascadeType.ALL
		// //here as we added mappedBy="post" it wont create mapping table post_comment
		// @OneToMany(mappedBy = "post",fetch = FetchType.EAGER,cascade =
		// CascadeType.ALL)
//		private List<Comment> comments;
		
		//check notes
		
		session.save(post1);

		tx.commit();

	}

}
