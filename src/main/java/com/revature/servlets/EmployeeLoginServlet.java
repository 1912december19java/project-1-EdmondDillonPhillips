package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.EmployeeModel;
import com.revature.repository.EmployeeDaoPostgres;
import com.revature.services.EmployeeService;

@WebServlet(name="EmployeeServlet", urlPatterns= {"/employeelogin"})
public class EmployeeLoginServlet extends HttpServlet {

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
		System.out.println("Hello from login getmethod");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("A request was made to " + req.getMethod() + " at " + req.getRequestURL());
		String employeeNumber = req.getParameter("employeeNumber");
//		HttpSession session = req.getSession();
//		session.setAttribute("employee", employeeNumber); 
		
//		EmployeeModel setEmployee = new EmployeeModel(employeeNumber, firstName, lastName, email, title, reportsTo);
		
		EmployeeModel employee = employeeService.get(employeeNumber);
		employee.setEmployeeFirstName(employee.getEmployeeFirstName());
		EmployeeModel employeeFirstName;
		EmployeeModel employeeLastName;
		EmployeeModel employeeEmail;
		EmployeeModel employeeTitle;
		
		System.out.println(employee.getEmployeeFirstName());
		System.out.println(employee.getEmployeeLastName());
		System.out.println(employee.getEmployeeEmail());
		System.out.println(employee.getEmployeeTitle());
		System.out.println(employee.getReportsTo());
		
		resp.sendRedirect("EmployeePage.html");
		
	}
}
