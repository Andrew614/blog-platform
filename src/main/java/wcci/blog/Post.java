package wcci.blog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	private String title;
	private String content;
	private LocalDateTime publishDate;
	
	@ManyToOne
	private Author author;
	
	@ManyToOne
	private Category category;
	
	@ManyToMany
	private Collection<Tag> tags;

	@Id
	@GeneratedValue
	private long id;
	
	protected Post() {}

	public Post(String title, Author author, Category category, String content, Tag... tags) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.content =content;
		this.tags = new ArrayList<Tag>();
		for(Tag tag: tags) {
			this.tags.add(tag);
		}
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Author getAuthor() {
		return author;
	}

	public LocalDateTime getPublishDate() {
		return publishDate;
	}

	public Category getCategory() {
		return category;
	}

	public Collection<Tag> getTag() {
		return tags;
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
		Post other = (Post) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
