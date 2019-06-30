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

public class PostControllerTest {

	@InjectMocks
	private PostController underTest;
	
	@Mock
	private PostRepository postRepo;
	
	@Mock
	private Model model;
	
	@Mock
	private Post post1;
	
	@Mock
	private Post post2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldHavePostsInModel() {
		Collection<Post> posts = Arrays.asList(post1, post2);
		when(postRepo.findAll()).thenReturn(posts);
		underTest.getAllPosts(model);
		verify(model).addAttribute("postsAttribute", posts);
	}
	
	@Test
	public void shouldBeAbleToGetAllPosts() {
		String post = underTest.getAllPosts(model);
		assertThat(post, is("postsTemplate"));
	}
	
	@Test
	public void shouldHaveOnePostInModel() {
		Optional<Post> post = Optional.of(post1);
		when(postRepo.findById(post1.getId())).thenReturn(post);
		underTest.getOnePost(0L, model);
		verify(model).addAttribute("postAttribute", post);
	}
	
	@Test
	public void shouldBeAbleToGetOnePost() {
		String post = underTest.getOnePost(0L, model);
		assertThat(post, is("postTemplate"));
	}
	
}
