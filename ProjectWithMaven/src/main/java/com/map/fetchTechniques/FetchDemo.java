package com.map.fetchTechniques;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.oneToMany.Comment;
import com.map.oneToMany.Post;

public class FetchDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Post post = session.get(Post.class, 1);
		System.out.println("Post Id->" + post.getPostId());
		System.out.println("Post Desc->" + post.getPost());
		//so here When we get comments than only comments Query us executed so this is called lazy loading 
		//Means at that time Db called is done,by Default it is lazy loading
		//We need to go and add 
		//@OneToMany(mappedBy = "post",fetch = FetchType.EAGER) in VO
		//1)Lazy loading-> comments table will be called when getter of comment is printed or used
		//2)Eager loading-> All data of Post and comments will be loaded in one go when get() is called/used
		
		//System.out.println("Comments Size->" + post.getComments().size());

	}

}
