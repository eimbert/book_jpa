package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Book;

public interface IBookService {

	public List<Book> findAll();
	public void save(Book book);
	public void delete(String id);
	public Book findOne(String id);
}
