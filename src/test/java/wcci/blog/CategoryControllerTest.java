package wcci.blog;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class CategoryControllerTest {

	@InjectMocks
	private CategoryController underTest;

	@Mock
	private CategoryRepository categoryRepo;

	@Mock
	private Model model;

	@Mock
	private Category category1;

	@Mock
	private Category category2;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldHaveCategoriesInModel() {
		Collection<Category> categories = Arrays.asList(category1, category2);
		Mockito.when(categoryRepo.findAll()).thenReturn(categories);
		underTest.getAllCategories(model);
		verify(model).addAttribute("categoriesAttribute", categories);
	}
	
	@Test
	public void shouldBeAbleToGetAllCategories() {
		String categories = underTest.getAllCategories(model);
		assertThat(categories, is("categoriesTemplate"));
	}
	
	@Test
	public void shouldBeAbleToGetOneCategory() {
		String category = underTest.getOneCategory(model, 0L);
		assertThat(category, is("categoryTemplate"));
	}
	
	@Test
	public void shouldHaveCategoryInModel() {
		Optional<Category> category = Optional.of(category1);
		Mockito.when(categoryRepo.findById(category1.getId())).thenReturn(category);
		underTest.getOneCategory(model, 0L);
		verify(model).addAttribute("categoryAttribute", category);
	}
	
	
}
