package com.tut.ProjectWithMaven;

import javax.persistence.Embeddable;

//@Embeddable means, adding fields of that class into other Table,For eg here course and duration will be field in student table along with all fields of student
//Hibernate: insert into Student (course, duration, city, name, id) values (?, ?, ?, ?, ?)
//Hibernate: insert into Student (course, duration, city, name, id) values (?, ?, ?, ?, ?)
//Used when we want to embedded fields from one class into other class

@Embeddable
public class Certificate {

	private String course;
	private String duration;

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certificate(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
