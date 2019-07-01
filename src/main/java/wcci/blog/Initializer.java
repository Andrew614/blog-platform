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
		Author author1 = new Author("Wonder Woman");
		Author author2 = new Author("Deadpool");
		Author author3 = new Author("Jessica Jones");
		Author author4 = new Author("Luke Cage");
		Author author5 = new Author("Captain America");
		Author author6 = new Author("Iron Man");
		authorRepo.save(author1);
		authorRepo.save(author2);
		authorRepo.save(author3);
		authorRepo.save(author4);
		authorRepo.save(author5);
		authorRepo.save(author6);
		Category category1 = new Category("popery");
		Category category2 = new Category("music");
		Category category3 = new Category("comics");
		Category category4 = new Category("food");
		Category category5 = new Category("drinks");
		Category category6 = new Category("life");
		categoryRepo.save(category1);
		categoryRepo.save(category2);
		categoryRepo.save(category3);
		categoryRepo.save(category4);
		categoryRepo.save(category5);
		categoryRepo.save(category6);
		Tag tag1 = new Tag("legend");
		Tag tag2 = new Tag("heros");
		Tag tag3 = new Tag("coke");
		Tag tag4 = new Tag("country trap");
		Tag tag5 = new Tag("beer");
		Tag tag6 = new Tag("pop");
		tagRepo.save(tag1);
		tagRepo.save(tag2);
		tagRepo.save(tag3);
		tagRepo.save(tag4);
		tagRepo.save(tag5);
		tagRepo.save(tag6);
		Post post1 = new Post("title1", author1, category1, "content1", tag1);
		Post post2 = new Post("title2", author2, category2, "content2", tag2);
		Post post3 = new Post("title3", author3, category3, "content3", tag3);
		Post post4 = new Post("title4", author4, category4, "content4", tag4);
		Post post5 = new Post("title5", author5, category5, "content5", tag5);
		Post post6 = new Post("title6", author6, category6, "content6", tag6);
		Post post7 = new Post("title7", author3, category5, "content7", tag3);
		Post post8 = new Post("title8", author1, category2, "content8", tag4);
		Post post9 = new Post("title9", author5, category6, "content9", tag5);
		postRepo.save(post1);
		postRepo.save(post2);
		postRepo.save(post3);
		postRepo.save(post4);
		postRepo.save(post5);
		postRepo.save(post6);
		postRepo.save(post7);
		postRepo.save(post8);
		postRepo.save(post9);
		
	}
}
