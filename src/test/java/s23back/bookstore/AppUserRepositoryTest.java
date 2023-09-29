package s23back.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import s23back.bookstore.domain.AppUser;
import s23back.bookstore.domain.AppUserRepository;

@DataJpaTest
public class AppUserRepositoryTest {

	// inject repository class to test class
	@Autowired
	private AppUserRepository repository;
	
	// Test search
	@Test
	public void findByUsernameReturnsUser() {
		AppUser user = repository.findByUsername("admin");
		assertThat(user.getId()).isNotNull();
	}
	
	// Test create
	@Test
	public void createNewAppUser() {
		AppUser user = new AppUser("newuser",
				"$2a$10$o1KWro522fJJG5QvjiK5geR1mkZ5G1nQByRQvZv9PDqM9HRBmPqHW", 
				"newuser@bookstore.com", "USER");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	// Test delete
	@Test
	public void deleteNewAppUser() {
		AppUser user = repository.findByUsername("admin");
		repository.delete(user);
		AppUser newUser = repository.findByUsername("admin");
		assertThat(newUser).isNull();
	}
	
}
