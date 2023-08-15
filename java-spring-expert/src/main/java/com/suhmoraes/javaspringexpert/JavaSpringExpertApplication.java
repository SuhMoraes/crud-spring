package com.suhmoraes.javaspringexpert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@EntityScan
public class JavaSpringExpertApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringExpertApplication.class, args);
	}

}
