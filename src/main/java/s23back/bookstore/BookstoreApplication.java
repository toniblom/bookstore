package s23back.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23back.bookstore.domain.Book;
import s23back.bookstore.domain.BookRepository;
import s23back.bookstore.domain.Category;
import s23back.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Sci-fi"));
			crepository.save(new Category("Children"));
			
			Book b1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "1234-56", 39.99, crepository.findByName("Fantasy").get(0));
			Book b2 = new Book("The Chronicles of Narnia", "C.S. Lewis", 1956, "2222-22", 34.99, crepository.findByName("Children").get(0));
			Book b3 = new Book("Neuromancer", "William Gibson", 1984, "2333-23", 29.99, crepository.findByName("Sci-fi").get(0));
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
