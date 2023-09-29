package s23back.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import s23back.bookstore.domain.Category;
import s23back.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

	// inject repository class to test class
	@Autowired
	private CategoryRepository repository;
	
	// Test search
	@Test
	public void findByNameReturnsCategory() {
		List<Category> categories = repository.findByName("Fantasy");
		assertThat(categories).hasSize(1);
	}
	
	// Test create
	@Test
	public void createNewCategory() {
		Category category = new Category("Poetry");
		repository.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}
	
	// Test delete
	@Test
	public void deleteNewCategory() {
		List<Category> categories = repository.findByName("Fantasy");
		Category category = categories.get(0);
		repository.delete(category);
		List<Category> newCategories = repository.findByName("Fantasy");
		assertThat(newCategories).hasSize(0);
	}
	
}
