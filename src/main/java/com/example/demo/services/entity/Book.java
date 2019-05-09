package com.example.demo.services.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;



@Entity
@Table(name = "books")
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String title;
	@NotEmpty
	private String ISBN;
	@Min(value =  1, message = "El número de paginas debe de ser mayor a 0.")
	private int pages;

	public String getTitle() {
		return title;
	}

	public void setTitle(String Title) {
		this.title = Title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Book(String title, String ISBN, int pages) {
		super();
		this.title = title;
		this.ISBN = ISBN;
		this.pages = pages;
	}

	public Book() {
		super();
	}

}
