package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repositories.IBooksDao;
import com.example.demo.services.entity.Book;

import javafx.beans.binding.Binding;

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
		model.addAttribute("book", book);
		model.addAttribute("library", service.findAll());
		return "index";
	}

	@RequestMapping("/newBook")
	public String crear (Model model) {
		
		model.addAttribute("titulo", "Formulario nuevo libro");
		model.addAttribute("book", book);
		return "new_book.html";
	}
	
	@RequestMapping(value="/newBook", method = RequestMethod.POST) 
	public String insertBook (@Valid Book book, BindingResult result, Model model) {
			 if(result.hasErrors()) {
				 model.addAttribute("titulo", "Formulario nuevo libro");
				 return "newBook";
			 }
			 service.save(book); 
			 return "redirect:library"; 
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST) 
	public String deleteBook (Book book) {
			  
			 //service.delete(book); 
			 return "redirect:library"; 
	}
	
	/*
	 * @RequestMapping("/newBook") public String newBook(Model model) {
	 * 
	 * model.addAttribute("titulo", "Alta de libro"); +ç
	 * model.addAttribute("book", book); 
	 * return "new_book.html"; }
	 * 
	 * @RequestMapping("/insertBook") public String insertBook (Book book, Model
	 * model) {
	 * 
	 * //service.insertBook(book); model.addAttribute("library",service.findAll());
	 * model.addAttribute("titulo", "Listado libros disponibles"); return
	 * "index.html"; }
	 * 
	 * @RequestMapping("/deleteBook") public String deleteBook(@RequestParam("book")
	 * Book book, Model model) {
	 * 
	 * //service.deleteBook(book); model.addAttribute("titulo", book.getTitle());
	 * model.addAttribute("library",service.findAll());
	 * 
	 * return "index.html"; }
	 */

}

	

