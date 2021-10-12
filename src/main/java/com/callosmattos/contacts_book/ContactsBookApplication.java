package com.callosmattos.contacts_book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.callosmattos.contacts_book"})
@EntityScan("com.callosmattos.contacts_book.models")
@EnableJpaRepositories("com.carllosmattos.contacts_book.repository")
public class ContactsBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsBookApplication.class, args);
	}

}
