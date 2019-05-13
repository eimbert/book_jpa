package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Book;
import com.example.demo.models.entity.weather.WeatherRest;

public interface IBookService {

	public List<Book> findAll();
	public void save(Book book);
	public void delete(String id);
	public Book findOne(String id);
	public WeatherRest findWeatherIn(String city, String codeCounty);
}
