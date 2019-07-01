package wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TagController {
	@Autowired
	private TagRepository tagRepo;

	@RequestMapping("/tags")
	public String getAllTags(Model model) {
		model.addAttribute("tagsAttribute", tagRepo.findAll());
		return "tagsTemplate";
	}

	@RequestMapping("/tags/{id}")
	public String getOneTag(Model model, @PathVariable long id) {
		model.addAttribute("tagAttribute", tagRepo.findById(id).get());
		return "tagTemplate";
	}

	@PostMapping("/tags/add")
	public String addTag(String tag) {
		Tag tagToAdd = new Tag(tag);
		if (tagRepo.findByName(tagToAdd.getName()) == null) {
            tagRepo.save(tagToAdd);
        }	
		return "redirect:/tags";
	}

}
