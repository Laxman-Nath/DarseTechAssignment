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

@WebServlet("/BookDeleteServlet")
public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  private BookService bookService=new BookServiceImpl();
    public BookDeleteServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int affectedRows = bookService.deleteBook(Integer.parseInt(request.getParameter("id")));
		if (affectedRows > 0) {
			request.setAttribute("statusCode", HttpServletResponse.SC_OK);
		} else {
			request.setAttribute("status",HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		request.setAttribute("books",bookService.viewAllBooks());
		request.getRequestDispatcher("viewbooks.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
