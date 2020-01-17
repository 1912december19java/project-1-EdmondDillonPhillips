package com.revature.servlets;

import java.io.IOException;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.models.EmployeeModel;
import com.revature.repository.EmployeeDao;
import com.revature.repository.EmployeeDaoPostgres;

@WebServlet(name="Employees", urlPatterns= {"/employee"})
public class EmployeeServlet extends HttpServlet {
//  
//  private EmployeeDaoPostgres employeeDao;
  private static ObjectMapper om = new ObjectMapper();
//  
//  //Lifecycle methods: init, service, destroy
//  @Override
//  public void init() throws ServletException {
////    System.out.println("Initializing Employee: " + getServletName());
//    this.employeeDao =  new EmployeeDaoPostgres();
//    this.om = new ObjectMapper();
////    super.init();
//  }
// 

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
      ObjectMapper om = new ObjectMapper();
      EmployeeModel emp = om.readValue(req.getReader(), EmployeeModel.class);
    
      System.out.println("URI:" + req.getRequestURI());
      String employeeName = req.getParameter("employeeNumber");
      System.out.println("The Req object is : " + req);
      System.out.println(" employeeName Req parameter is: " + employeeName);
      
      

    
      EmployeeDao employeeDao = new EmployeeDaoPostgres();
      
      EmployeeModel employee1 = employeeDao.get("E001");
      
      System.out.println("Hello From Servlet");

      System.out.println(employee1.getEmployeeNumber());
      System.out.println(employee1.getEmployeeFirstName());
      System.out.println(employee1.getEmployeeLastName());
      System.out.println(employee1.getEmployeeTitle());
      System.out.println(employee1.getEmployeeEmail());
      
      
//      om.writeValueAsString(employee1)
      resp.getWriter().write(om.writeValueAsString(employee1));
  }
  

}
