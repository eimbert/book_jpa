package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.Repositories.IBooksDao;
import com.example.demo.services.entity.Book;


@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	@Qualifier("clienteDaoJPA")
	IBooksDao service;
	
	@Autowired
	Book book;
	
	@RequestMapping("/library")
	public String showBooks (Model model) {
		
		model.addAttribute("titulo", "Listado de libros disponibles");
		model.addAttribute("library", service.findAll());
		return "index";
	}

	@RequestMapping("/newBook")
	public String crear (Model model) {
		
		model.addAttribute("titulo", "Formulario nuevo libro");
		model.addAttribute("book", book);
		return "new_book";
	}
	
	@RequestMapping(value="/newBook", method = RequestMethod.POST) 
	public String insertBook (@Valid Book book, BindingResult result, Model model) {
			 if(result.hasErrors()) {
				 model.addAttribute("titulo", "Formulario nuevo libro");
				 return "new_book";
			 }
			 service.save(book); 
			 return "redirect:library"; 
	}
	
	@RequestMapping(value="/delete/{title}") 
	public String deleteBook (@PathVariable(value="title") String id, Model model) {
			 
			 service.delete(id); 
			 return "redirect:/books/library"; 
	}
}

	

