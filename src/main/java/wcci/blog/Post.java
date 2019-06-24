package wcci.blog;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {

	private String title;
	private String content;

	private Author author;
	private LocalDateTime publishDate;
	private Category category;
	private Tag tag;

	@Id
	@GeneratedValue
	private long id;

	public Post(String title, Author author, Category category, Tag tag, String content) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.tag = tag;
		this.content =content;
		

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

	public Tag getTag() {
		return tag;
	}
}
