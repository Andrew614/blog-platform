package wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@RequestMapping("/categories")
	public String getAllCategories(Model model) {
		model.addAttribute("categoriesAttribute", categoryRepo.findAll());
		return "categoriesTemplate";
		
	}
	@RequestMapping("/categories/{id}")
	public String getOneCategory(Model model, @PathVariable Long id) {
		model.addAttribute("categoryAttribute", categoryRepo.findById(id).get());
		return "categoryTemplate";
	}
	
	@PostMapping("/categories/add")
	public String addCategory(String category) {
		Category categoryToAdd = new Category(category);
		if (categoryRepo.findByName(categoryToAdd.getName()) == null) {
			categoryRepo.save(categoryToAdd);
        }	
		return "redirect:/categories";
	}

}
