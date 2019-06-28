package wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class TagController {
	@Autowired
	private TagRepository tagRepo;

	public String getAllTags(Model model) {
	model.addAttribute("tagsAttribute", tagRepo.findAll());
		return "tagsTemplate";
	}

	public String getOneTag(Model model, long id) {
	model.addAttribute("tagAttribute", tagRepo.findById(id));
		return "tagTemplate";
	}

	

}
