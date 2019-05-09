package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.services.entity.Book;

@Configuration
public class AppConfig {
	
	@Bean
	public Book regitroBook() {
		return new Book();
	}

}
