package wcci.blog;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	private String name;

	@ManyToMany(mappedBy = "tags")
	private Collection<Post> posts;

	@Id
	@GeneratedValue
	private Long id;

	protected Tag() {
	}

	public Tag(String name) {
		this.name = name;
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
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Tag other = (Tag) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
