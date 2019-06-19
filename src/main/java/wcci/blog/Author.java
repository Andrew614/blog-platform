package wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {

	private String name;
	private Post post;
	
	@Id
	@GeneratedValue
	private long id;
	
	protected Author() {
	}
	
	public Author(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Post getPost() {
		return post;
	}
	
	
}
