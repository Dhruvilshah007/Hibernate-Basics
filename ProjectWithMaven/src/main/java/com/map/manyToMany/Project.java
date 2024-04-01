package com.map.manyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Project {
	@Id
	private int pid;

	@Column(name = "project_name")
	private String projectName;

	//If we write this then no table with project_empwill be created
	@ManyToMany(mappedBy = "projects")  
//	@ManyToMany
	private List<Emp> emps;

}
