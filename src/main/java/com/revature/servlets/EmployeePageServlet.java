package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.EmployeeModel;
import com.revature.repository.EmployeeDaoPostgres;
import com.revature.services.EmployeeService;

@WebServlet(name="EmployeePageServlet", urlPatterns= {"/employeePage"})
public class EmployeePageServlet extends HttpServlet {

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("A request was made to the EmployePageServlet");
		System.out.println("A request was made to EmployePageServlet " + req.getMethod() + " at " + req.getRequestURL());

		
		
		
		
		
	}
}
