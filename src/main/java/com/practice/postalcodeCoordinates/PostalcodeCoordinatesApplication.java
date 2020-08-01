package com.practice.postalcodeCoordinates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
public class PostalcodeCoordinatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostalcodeCoordinatesApplication.class, args);
	}

}
