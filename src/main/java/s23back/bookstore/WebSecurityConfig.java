package s23back.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import s23back.bookstore.web.UserDetailServiceImpl;

@Configuration
public class WebSecurityConfig {

	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize
				// .requestMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()

		).formLogin(formlogin -> formlogin.loginPage("/login").defaultSuccessUrl("/booklist", true).permitAll())
				.logout(logout -> logout.permitAll());
		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}