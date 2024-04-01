package com.map.manyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Emp {

	@Id
	private int eid;

	private String name;
	
	//Here join table will change table name to emp_learn from emp_project
	//joincolumns will change column name from emps_eid ->eid and projects_pid->pid
	@ManyToMany
	@JoinTable(name = "emp_learn", joinColumns = { @JoinColumn(name = "eid") }, inverseJoinColumns = {@JoinColumn(name = "pid")})
	private List<Project> projects;

}
