package wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepo;

	@RequestMapping("/authors")
	public String findAll(Model model) {
		model.addAttribute("authorsAttribute", authorRepo.findAll());
		return "authorsTemplate";

	}
	@RequestMapping("/authors/{id}")
	public String getOneAuthor(Model model, @PathVariable long id) {
		model.addAttribute("authorAttribute", authorRepo.findById(id).get());
		return "authorTemplate";
	}

}
