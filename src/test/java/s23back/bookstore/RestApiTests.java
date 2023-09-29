package s23back.bookstore;

//import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class RestApiTests {
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void checkStatus() throws Exception {
		this.mockMvc.perform(get("/books")).andExpect(status().isOk());
	}
	
	@Test
	public void checkResponseTypeJSON() throws Exception {
		this.mockMvc.perform(get("/books")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	
	@Test
	public void apiStatusIsOk() throws Exception {
		this.mockMvc.perform(get("/api/books")).andExpect(status().isOk());
	}
	
	// Do I need to test something else here?

}










