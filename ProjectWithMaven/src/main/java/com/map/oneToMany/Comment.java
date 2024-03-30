package com.map.oneToMany;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

	@Id
	@Column(name = "comment_id")
	private int commentId;

	private String comment;

	@ManyToOne
	private Post post;

}
