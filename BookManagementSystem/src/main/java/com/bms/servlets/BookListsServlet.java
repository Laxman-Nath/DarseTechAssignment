package com.bms.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bms.entities.Book;
import com.bms.services.BookService;
import com.bms.services.BookServiceImpl;

@WebServlet("/viewBooks")
public class BookListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();

	public BookListsServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> books=bookService.viewAllBooks();
		request.setAttribute("books", books);
		request.getRequestDispatcher("viewbooks.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		doGet(request, response);
	}

}
