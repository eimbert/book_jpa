package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Book;
import com.example.demo.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService service;
	
	@RequestMapping("/library")
	public String showBooks (Model model) {
		
		model.addAttribute("titulo", "Listado de libros disponibles");
		model.addAttribute("library", service.findAll());
		return "index";
	}

      @RequestMapping("/newBook")
	public String newBook(Model model) {
		
    	model.addAttribute("titulo", "Alta de libro");
    	model.addAttribute("book", new Book());
		return "new_book.html";
	}
	
	@RequestMapping("/insertBook")
	public String insertBook (Book book, Model model) {
		
		service.insertBook(book);
		model.addAttribute("library",service.findAll());
		model.addAttribute("titulo", "Listado libros disponibles");
		return "index.html";	}
	
	@RequestMapping("/deleteBook")
	public String deleteBook(Book book, Model model) {
				
		service.deleteBook(book);
		model.addAttribute("library",service.findAll());
		
		return "index.html";
	}

}

	

