package com.map.oneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

	@Id
	@Column(name = "post_id")
	private int postId;

	private String post;
	
	//here as we added mappedBy="post" it wont create mapping table post_comment
	@OneToMany(mappedBy = "post",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Comment> comments;
}
