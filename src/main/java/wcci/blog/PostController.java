package wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class PostController {

	@Autowired
	private PostRepository postRepo;

	@RequestMapping("/posts")
	public String getAllPosts(Model model) {
		model.addAttribute("postsAttribute", postRepo.findAll());
		return "postsTemplate";
	}

	public String getOnePost(Model model, long id) {
		model.addAttribute("postAttribute", postRepo.findById(id));
		return "postTemplate";
		
	}
	
	
	
	@PostMapping("/add")
	public String addPost(String title, String authorString, String categoryString, String content, String tagsString) {
		Category category = new Category(categoryString);
		Author author = new Author(authorString);
		Tag tag = new Tag(tagsString);
		postRepo.save(new Post(title, author, category, content, tag));
		return "redirect:/posts";
		
	}

}
