package wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {

	private String name;
	private Post post;

	public Tag(String name) {

	}

	public String getName() {
		return name;
	}

	public Post getPost() {
		return post;
	}

	public long getId() {
		return id;
	}

	@Id
	@GeneratedValue
	private long id;
}
