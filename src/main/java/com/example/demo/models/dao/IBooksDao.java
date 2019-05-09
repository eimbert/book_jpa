package com.example.demo.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Book;

public interface IBooksDao extends CrudRepository<Book, String>  {


}
