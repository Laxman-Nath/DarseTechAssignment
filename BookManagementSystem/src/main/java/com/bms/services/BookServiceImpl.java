package com.bms.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bms.entities.Book;
import com.bms.repositories.BookRepo;


public class BookServiceImpl implements BookService {

	private PreparedStatement ps = null;
	private Connection connection = null;

	private boolean checkConnection() {
		connection = BookRepo.getConnection();
		System.out.println("Connection" + connection);
		return connection == null ? false : true;
	}

	@Override
	public int addBook(Book b) {

		if (checkConnection()) {
			try {
				ps = connection.prepareStatement("INSERT INTO book(name,isbn) VALUES(?,?)");

				ps.setString(1, b.getName());
				ps.setString(2, b.getIsbn());
				return ps.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return 0;
	}

	@Override
	public int updateBook(int bookId, Book book) {
//		System.out.println(book.getName() instanceof String);
//		System.out.println(bookId+","+","+book.getIsbn());
		if (checkConnection()) {
			try {
				ps = connection.prepareStatement("UPDATE book SET name=?, isbn=? WHERE id=?");
				ps.setString(1, book.getName());
				ps.setString(2, book.getIsbn());
				 ps.setInt(3, bookId);
				return ps.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return 0;

	}

	@Override
	public int deleteBook(int bookId) {

		if (checkConnection()) {
			try {
				ps = connection.prepareStatement("DELETE FROM book WHERE id=?");
				ps.setInt(1, bookId);
				return ps.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return 0;
	}

	@Override
	public List<Book> viewAllBooks() {
		if (checkConnection()) {
			try {
				List<Book> books = new ArrayList<Book>();
				ps = connection.prepareStatement("SELECT * FROM  book");

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					books.add(new Book(rs.getInt("id"), rs.getString("name"), rs.getString("isbn")));
				}
				System.out.println(books);
				return books;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return null;
	}

	@Override
	public Book getBookById(int id) {
		if (checkConnection()) {
			try {
				ps = connection.prepareStatement("SELECT * FROM book WHERE id=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					return new Book(rs.getInt("id"), rs.getString("name"), rs.getString("isbn"));
				}

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return null;
	}

}
