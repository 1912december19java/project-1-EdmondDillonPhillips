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

@WebServlet(name="EmployeeUpdateServlet", urlPatterns= {"/employeeupdate"})

public class EmployeeUpdateServlet extends HttpServlet {
	
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
		System.out.println("A request was made to " + req.getMethod() + " at " + req.getRequestURL());
		resp.getWriter().write("Some text");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("A request was made to " + req.getMethod() + " at " + req.getRequestURL());
//		String employeeNumber = req.getParameter("employeeNumber");
//		System.out.println(employeeNumber);
//===================================================================================================================
		EmployeeModel receivedEmployee = om.readValue(req.getReader(), EmployeeModel.class);
		String empNum = receivedEmployee.getEmployeeNumber();
		System.out.println(empNum);
		System.out.println(receivedEmployee.getEmployeeFirstName());
		//===================================================================================================================
		//------------------------------------ Update ----------------------------------------------------------------------
		//===================================================================================================================
		employeeService.update(receivedEmployee);
		
		
		
		
		//===================================================================================================================
		//------------------------------------ Get ----------------------------------------------------------------------
		//===================================================================================================================
//		HttpSession session = req.getSession();
//		session.setAttribute("employee", employeeNumber); 
//		System.out.println(employeeNumber);
//		EmployeeModel setEmployee = new EmployeeModel(employeeNumber, firstName, lastName, email, title, reportsTo);
		
		EmployeeModel employee = employeeService.get(empNum);
		String employeeNo = employee.getEmployeeNumber();
		String employeeFirstName = employee.getEmployeeFirstName();
		String employeeLastName = employee.getEmployeeLastName();
		String employeeEmail = employee.getEmployeeEmail();
		String employeeTitle = employee.getEmployeeTitle();
		
//==================================================================================================
		System.out.println(om.writeValueAsString(employee));
		System.out.println(employeeNo);
		System.out.println(employeeFirstName);
		System.out.println(employeeLastName);
		System.out.println(employeeEmail);
		System.out.println(employeeTitle);
//==================================================================================================

		resp.getWriter().write(om.writeValueAsString(employee));
		
//		employee.setEmployeeFirstName(employee.getEmployeeFirstName());

		

		
//		resp.sendRedirect("EmployeePage.html");

	}

}
