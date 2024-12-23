package com.bms.swagger;
import io.swagger.v3.oas.models.OpenAPI;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/swagger.json")
public class SwaggerJsonServlet extends HttpServlet{
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        OpenAPI openAPI = (OpenAPI) getServletContext().getAttribute("openAPI");

	        if (openAPI == null) {
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "OpenAPI object not initialized");
	            return;
	        }


	        ObjectMapper objectMapper = new ObjectMapper();
	        
	      
	        response.setContentType("application/json");
	        
	   
	        response.getWriter().write(objectMapper.writeValueAsString(openAPI));
	    }
}
