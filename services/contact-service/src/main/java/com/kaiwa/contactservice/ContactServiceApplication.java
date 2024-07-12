package com.kaiwa.contactservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ContactServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactServiceApplication.class, args);
	}

}