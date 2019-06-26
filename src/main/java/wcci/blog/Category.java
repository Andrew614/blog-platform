package wcci.blog;

import java.util.Collection;

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
	private long id;

	protected Category() {

	}

	public Category(String name) {

	}

	public String getName() {
		return name;
	}

	public Collection<Post> getPost() {
		return posts;
	}

	public Long getId() {
		return id;
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
