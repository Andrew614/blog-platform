package wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepo;
	
	
	public String getAllCategories(Model model) {
		model.addAttribute("categoriesAttribute", categoryRepo.findAll());
		return "categoriesTemplate";
		
	}

	public String getOneCategory(Model model, Long id) {
		model.addAttribute("categoryAttribute", categoryRepo.findById(id));
		return "categoryTemplate";
	}

}
