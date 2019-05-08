package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Book;


public interface BookRepository extends CrudRepository<Book,String> {

	
}
