package wcci.blog;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag findByName(String name);

}
