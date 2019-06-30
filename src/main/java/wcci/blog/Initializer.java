package wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private PostRepository postRepo;
	
	@Autowired 
	private CategoryRepository categoryRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private TagRepository tagRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Author author1 = new Author("author1");
		authorRepo.save(author1);
		Category category1 = new Category("category1");
		categoryRepo.save(category1);
		Tag tag1 = new Tag("tag1");
		tagRepo.save(tag1);
		Post post1 = new Post("title", author1, category1, "content", tag1);
		postRepo.save(post1);
		
	}
}
