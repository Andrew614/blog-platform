package wcci.blog;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PostTest {

	@Test
	public void canCreatePost() {
		Author author = new Author("bob");
		Category cat = new Category("cat");
		Tag tag = new Tag("stuff");

		Post undertest = new Post("title", author, cat, "content", tag);
		String expectedTitle = undertest.getTitle();
		String expectedContent = undertest.getContent();

		assertThat(expectedTitle, is("title"));
		assertThat(expectedContent, is("content"));
		assertThat(undertest.getAuthor().getName(), is("bob"));
		assertThat(undertest.getCategory(), is(cat));
		assertThat(undertest.getTags(), contains(tag));

	}

}
