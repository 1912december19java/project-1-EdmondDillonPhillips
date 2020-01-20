package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.EmployeeModel;
//import com.revature.repository.EmployeeDao;
import com.revature.repository.EmployeeDaoPostgres;
import com.revature.services.EmployeeService;

@WebServlet(name="EmployeeServlet", urlPatterns= {"/getemployee", "/postemployee"})

public class EmployeeServlet extends HttpServlet {
	
	  private EmployeeService employeeService;
	  private ObjectMapper om;
	  
	  @Override
	  public void init() throws ServletException {
	    this.employeeService =  new EmployeeService(new EmployeeDaoPostgres());
	    this.om = new ObjectMapper();
	    super.init();
	  }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("A request was made to the employee doget method");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = "This is a message from the doPost method in Employee Servlet";

		System.out.println("A request was made to " + req.getMethod() + " at " + req.getRequestURL());
		
//		EmployeeModel receivedEmployee = om.readValue(req.getReader(), EmployeeModel.class);
//		String empNum = receivedEmployee.getEmployeeNumber();
//		System.out.println(empNum);
		

		
////		EmployeeDao employeeDao = new EmployeeDaoPostgres();
////		EmployeeModel employee = employeeService.get(empNum);
//		System.out.println(employee.getEmployeeFirstName());
//		System.out.println(employee.getEmployeeLastName());
//		System.out.println(employee.getEmployeeEmail());
//		System.out.println(employee.getEmployeeTitle());
//		System.out.println(employee.getReportsTo());
//		System.out.println(msg);
		
//		resp.setContentType("text/html");  
//		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Project1/src/main/webapp/test.jsp");  
//        rd.forward(req,resp);  
		
//		resp.getWriter().write(om.writeValueAsString(employee));
//		resp.sendRedirect("EmployeePage.html");
//		ServletContext sc = getServletContext();
//		sc.getRequestDispatcher("/EmployeePage.html").forward(req, resp);
//		System.out.println(msg);
		resp.sendRedirect("EmployeePage.html");
		
    }

	}

