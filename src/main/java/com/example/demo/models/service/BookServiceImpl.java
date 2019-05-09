package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IBooksDao;
import com.example.demo.models.entity.Book;

//unico punto de acceso a diferentes dao o repositorios

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBooksDao bookDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Book> findAll() {
		return (List<Book>) bookDao.findAll();
	}

	@Override
	@Transactional
	public void save(Book book) {
		bookDao.save(book);
	}

	@Override
	@Transactional
	public void delete(String id) {
		bookDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Book findOne(String id) {
		return bookDao.findById(id).orElse(null);
	}

}
