package com.bms.entities;

public class Book {
	private int id;
	private String name;
	private String isbn;

	public String getName() {
		return name;
	}

	public Book(int id, String name, String isbn) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
	}

	public Book(String name, String isbn) {
		super();
		this.name = name;
		this.isbn = isbn;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
