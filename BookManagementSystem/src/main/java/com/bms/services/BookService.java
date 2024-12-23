package com.bms.services;

import com.bms.entities.Book;
import java.util.List;

public interface BookService {
	int addBook(Book b);

	int updateBook(int bookId, Book book);

	int deleteBook(int bookId);

	List<Book> viewAllBooks();
	
	Book getBookById(int id);

}
