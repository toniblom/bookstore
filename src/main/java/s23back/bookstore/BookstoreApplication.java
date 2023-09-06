package s23back.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23back.bookstore.domain.Book;
import s23back.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "1234-56", 39.99);
			Book b2 = new Book("The Chronicles of Narnia", "C.S. Lewis", 1956, "9876-54", 34.99);
			
			repository.save(b1);
			repository.save(b2);
		};
	}

}
