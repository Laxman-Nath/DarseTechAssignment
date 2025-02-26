package com.bms.servlets;

import java.io.IOException;
import java.util.List;

import com.bms.entities.Book;
import com.bms.services.BookService;
import com.bms.services.BookServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addBook")
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();

	public BookAddServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.getWriter().println("We are adding book");
		request.getRequestDispatcher("addbook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Book book = new Book(request.getParameter("name"), request.getParameter("isbn"));
		int affectedRows = bookService.addBook(book);
		if (affectedRows > 0) {
			request.setAttribute("statusCode", HttpServletResponse.SC_CREATED);
		} else {
			request.setAttribute("statusCode", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
		request.getRequestDispatcher("addbook.jsp").forward(request, response);
	}

}
