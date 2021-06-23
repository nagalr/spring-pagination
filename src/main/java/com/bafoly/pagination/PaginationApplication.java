package com.bafoly.pagination;

import com.bafoly.pagination.user.User;
import com.bafoly.pagination.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class PaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaginationApplication.class, args);
	}

	// populate 30 Users into H2 DB
	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> IntStream.rangeClosed(1, 30).forEach(i -> {
			User user = User.builder()
					.username("user" + i)
					.password("password")
					.email("user" + i + "@gmail.com")
					.build();
			userRepository.save(user);
		});
	}
}
