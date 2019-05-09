package com.example.demo.Repositories;

import java.util.List;

import com.example.demo.services.entity.Book;

public interface IBooksDao {

		public List<Book> findAll();
		public void save(Book book);
		public void delete(String id);
		public Book findOne(String id);
}
