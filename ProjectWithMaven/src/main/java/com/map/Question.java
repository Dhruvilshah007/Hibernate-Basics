package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

	@Id
	@Column(name = "queston_id")
	private int questionId;
	
	private String question;
	
	
	//used join column to rename columni database
	@OneToOne
	@JoinColumn(name = "a_id")
	private Answer answer;

}
