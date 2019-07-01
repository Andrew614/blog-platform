package wcci.blog;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	private String name;

	@OneToMany(mappedBy = "category")
	private Collection<Post> posts;

	@Id
	@GeneratedValue
	private Long id;

	protected Category() {

	}

	public Category(String name, Post... posts) {
		this.name = name;
		this.posts = new HashSet<>(Arrays.asList(posts));
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public Collection<Post> getPosts() {
		return posts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
