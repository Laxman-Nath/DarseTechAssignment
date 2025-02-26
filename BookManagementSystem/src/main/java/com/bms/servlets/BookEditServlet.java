package com.bms.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bms.entities.Book;
import com.bms.services.BookService;
import com.bms.services.BookServiceImpl;

@WebServlet("/BookEditServlet")
public class BookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();

	public BookEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	response.getWriter().print(request.getParameter("id"));	
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = bookService.getBookById(id);
		if (book == null) {
			request.setAttribute("statusCode", HttpServletResponse.SC_NOT_FOUND);
			request.getRequestDispatcher("viewbooks.jsp").forward(request, response);
		}
		request.setAttribute("book", book);
		request.getRequestDispatcher("bookeditform.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.getWriter().println(request.getParameter("name")+","+request.getParameter("id")+","+request.getParameter("isbn"));
//		doGet(request, response);

		int affectedRows = bookService.updateBook(Integer.parseInt(request.getParameter("id")),
				new Book(request.getParameter("name"), request.getParameter("isbn")));
		if (affectedRows > 0) {
			request.setAttribute("statusCode", HttpServletResponse.SC_OK);
		} else {
			request.setAttribute("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		request.setAttribute("books", bookService.viewAllBooks());
		request.getRequestDispatcher("viewbooks.jsp").forward(request, response);

	}

}
