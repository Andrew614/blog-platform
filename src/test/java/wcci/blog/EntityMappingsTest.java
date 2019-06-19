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
		entityManager.persist(author1);
		entityManager.flush();
		
		Author foundAuthor = authorRepo.findById(author1.getId()).get();
		assertThat(foundAuthor.getName(), is("author1"));
	}

}