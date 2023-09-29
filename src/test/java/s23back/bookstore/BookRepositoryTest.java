package s23back.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import s23back.bookstore.domain.Book;
import s23back.bookstore.domain.BookRepository;
import s23back.bookstore.domain.Category;

@DataJpaTest
public class BookRepositoryTest {
	
	// inject repository class to test class
	@Autowired
	private BookRepository repository;
	
	// Test search
	@Test
	public void findByTitleReturnsBook() {
		List<Book> books = repository.findByTitle("Neuromancer");
		assertThat(books).hasSize(1);
	}
	
	// Test create
	@Test
	public void createNewBook() {
		Book book = new Book("The Raven and Other Poems", "Edgar Allan Poe", 1845, 
				"123f4-56", 39.99, new Category("Poetry"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	// Test delete
	@Test
	public void deleteNewBook() {
		List<Book> books = repository.findByTitle("Neuromancer");
		Book book= books.get(0);
		repository.delete(book);
		List<Book> newBooks = repository.findByTitle("Neuromancer");
		assertThat(newBooks).hasSize(0);
	}

}








