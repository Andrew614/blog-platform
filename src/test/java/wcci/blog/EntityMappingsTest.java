package wcci.blog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntityMappingsTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AuthorRepository authorRepo;

	@Autowired
	private PostRepository postRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private TagRepository tagRepo;

	@Test
	public void shouldSaveAndLoadAuthor() {
		Author author1 = new Author("author1");
		authorRepo.save(author1);
		entityManager.flush();
		entityManager.clear();

		Author foundAuthor = authorRepo.findById(author1.getId()).get();
		assertThat(foundAuthor.getName(), is("author1"));
	}

	@Test
	public void shouldSaveAndLoadCategory() {
		Category cat2 = new Category("cat2");
		categoryRepo.save(cat2);
		entityManager.flush();
		entityManager.clear();

		Category foundCategory = categoryRepo.findById(cat2.getId()).get();
		assertThat(foundCategory, is(cat2));
	}

	@Test
	public void shouldSaveAndLoadTag() {
		Tag tag1 = new Tag("tag1");
		tagRepo.save(tag1);
		entityManager.flush();
		entityManager.clear();

		Tag foundTag = tagRepo.findById(tag1.getId()).get();
		assertThat(foundTag, is(tag1));
	}
	@Test
	public void shouldSaveAndLoadPost() {
		Author author1 = new Author("author1");
		Category cat = new Category("cat");
		Tag tag1 = new Tag("stuff1");
		Post testPost = new Post("title", author1, cat, "content", tag1);
		authorRepo.save(author1);
		categoryRepo.save(cat);
		tagRepo.save(tag1);
		postRepo.save(testPost);
		entityManager.flush();
		entityManager.clear();
		
		Post foundPost = postRepo.findById(testPost.getId()).get();
		assertThat(foundPost, is(testPost));
	}

}
