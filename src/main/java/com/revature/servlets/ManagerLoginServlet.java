package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.EmployeeModel;
import com.revature.models.ManagerModel;
import com.revature.repository.EmployeeDaoPostgres;
import com.revature.repository.ManagerDaoPostgres;
import com.revature.services.EmployeeService;
import com.revature.services.ManagerService;

@WebServlet(name="ManagerLoginServlet", urlPatterns={"/managerlogin"})
public class ManagerLoginServlet extends HttpServlet {
	
	
	  private ManagerService managerService;
	  private ObjectMapper om;

	  
	  @Override
	  public void init() throws ServletException {
	    this.managerService =  new ManagerService(new ManagerDaoPostgres());
	    this.om = new ObjectMapper();
	    
	    super.init();
	  }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("A request was made to " + req.getMethod() + " at " + req.getRequestURL());
//		String employeeNumber = req.getParameter("employeeNumber");
//		System.out.println(employeeNumber);
//===================================================================================================================
		ManagerModel receivedManager = om.readValue(req.getReader(), ManagerModel.class);
		String manNum = receivedManager.getManagerNumber();
		System.out.println(manNum);
		System.out.println("test");
//		HttpSession session = req.getSession();
//		session.setAttribute("employee", employeeNumber); 
//		System.out.println(employeeNumber);
//		EmployeeModel setEmployee = new EmployeeModel(employeeNumber, firstName, lastName, email, title, reportsTo);
		
		ManagerModel manager = managerService.get(manNum);
		String managerNo = manager.getManagerNumber();
		String managerFirstName = manager.getManagerFirstName();
		String managerLastName = manager.getManagerLastName();
		String managerEmail = manager.getManagerEmail();
		String managerTitle = manager.getManagerTitle();
		
//==================================================================================================
		System.out.println(om.writeValueAsString(manager));
		System.out.println(managerNo);
		System.out.println(managerFirstName);
		System.out.println(managerLastName);
		System.out.println(managerEmail);
//==================================================================================================

		resp.getWriter().write(om.writeValueAsString(manager));
		
//		employee.setEmployeeFirstName(employee.getEmployeeFirstName());

		

		
//		resp.sendRedirect("EmployeePage.html");
		
	}

}
