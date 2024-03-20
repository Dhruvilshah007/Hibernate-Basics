package com.tut.ProjectWithMaven;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Here for entity student_details is used when using hql queries for eg-
//Query query = entityManager.createQuery("SELECT s FROM student_details s WHERE s.age > 18");
//List<Student> students = query.getResultList();
//@Entity(name = "student_details")
//here only table name will be mystudents
//@Table(name = "mystudents")

@Entity
public class Student {

	@Id
	private int id;
	private String name;
	private String city;

	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return this.id + ":" + this.name + ":" + this.city;
	}

}
