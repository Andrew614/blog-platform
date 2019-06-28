package wcci.blog;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class TagControllerTest {

	@InjectMocks
	private TagController underTest;

	@Mock
	private TagRepository tagRepo;

	@Mock
	private Model model;

	@Mock
	private Tag tag1;

	@Mock
	private Tag tag2;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void shouldHaveTagsInModel() {
		Collection<Tag> tags = Arrays.asList(tag1, tag2);
		when(tagRepo.findAll()).thenReturn(tags);
		underTest.getAllTags(model);
		verify(model).addAttribute("tagsAttribute", tags);

	}
	@Test
	public void shouldBeAbleToGetAllTags() {
		String tags = underTest.getAllTags(model);
		assertThat(tags, is("tagsTemplate"));
	}

	@Test
	public void shouldBeAbleToGetOneTag() {
		String tag = underTest.getOneTag(model, 0L);
		assertThat(tag, is("tagTemplate"));

	}

	@Test
	public void shouldHaveTagInModel() {
		Optional<Tag> tag = Optional.of(tag1);
		when(tagRepo.findById(tag1.getId())).thenReturn(tag);
		underTest.getOneTag(model, 0L);
		verify(model).addAttribute("tagAttribute", tag);

	}

}
