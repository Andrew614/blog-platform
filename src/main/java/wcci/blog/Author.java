package wcci.blog;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Author {

	private String name;
	@OneToMany(mappedBy = "author")
	private Collection<Post> posts;
	
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
