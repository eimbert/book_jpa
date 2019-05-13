package com.example.demo.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.entity.Book;
import com.example.demo.models.entity.weather.WeatherRest;
import com.example.demo.models.service.IBookService;

@RestController
@RequestMapping("/webapi")
public class BookRestController {

	@Autowired
	IBookService repository;

	@GetMapping("/books")
	public Iterable<Book> findAll() {
		return repository.findAll();
	}

	@PostMapping(path = "/books", consumes = "application/json")
	public void insertBook(@RequestBody Book book) {
		repository.save(book);
	}

	@DeleteMapping("/books/{title}")
	public void deleteBook(@PathVariable String title) {	
			repository.delete(title);

	}
	
	@PutMapping(path = "/books", consumes = "application/json")
	public void updateBook(@RequestBody Book book) {
		repository.save(book);
	}
	
	
}
