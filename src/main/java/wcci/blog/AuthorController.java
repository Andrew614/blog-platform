package wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepo;

	public String findAll(Model model) {
		model.addAttribute("authorsAttribute", authorRepo.findAll());
		return "authorsTemplate";

	}

	public String getOneAuthor(Model model, long id) {
		model.addAttribute("authorAttribute", authorRepo.findById(id));
		return "authorTemplate";
	}

}
