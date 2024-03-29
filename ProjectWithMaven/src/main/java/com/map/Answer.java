package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Answer {

	@Id
	@Column(name = "answer_id")
	private int answerId;

	private String answer;
	
	//so, here in mappedBy foregin key will only be formed in Question and answer will act as FK.After adding this in answer table there wont be Question as FK
	@OneToOne(mappedBy = "answer")
	private Question question;

}
