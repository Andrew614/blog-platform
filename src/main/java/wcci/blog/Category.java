package wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

	public Category(String name) {
	
	}

	private String name;
	private Post post;

	@Id
	@GeneratedValue
	private long id;

	public String getName() {
		return name;
	}

	public Post getPost() {
		return post;
	}
	
	public Long getId() {
		return id;
	}
	
	

}
