package wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {

	private String name;
	private Post post;

	@Id
	@GeneratedValue
	private long id;
}
