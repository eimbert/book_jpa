package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.dao.IBooksDao;
import com.example.demo.models.entity.Book;
import com.example.demo.models.entity.weather.WeatherRest;

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

	@Override
	public WeatherRest findWeatherIn(String city, String codeCountry) {
		RestTemplate template = new RestTemplate();
		String urlConnect = "http://api.openweathermap.org/data/2.5/weather?q= {CITY},{CODECOUNTRY}&units=metric&APPID=aa915e3b02aabf7b8ebe393a76e8ff8f";
		urlConnect = urlConnect.replace("{CITY}", city).replace("{CODECOUNTRY}", codeCountry);
		ResponseEntity<WeatherRest> response = template.exchange(urlConnect, HttpMethod.GET, null, new ParameterizedTypeReference<WeatherRest>() {
				});
		
		WeatherRest weather= response.getBody();
		return weather;
	}
	

}
