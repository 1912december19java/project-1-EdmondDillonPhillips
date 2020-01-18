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
//
//  @Override
//  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//      throws ServletException, IOException {
//    
//      String body = req.getReader().toString();
//    
//    
//      ObjectMapper om = new ObjectMapper();
//     
//      EmployeeDao employeeDao = new EmployeeDaoPostgres();
//      
//      EmployeeModel employee1 = employeeDao.get(body);
//      
//      System.out.println("Hello From Servlet");
//
//      System.out.println(employee1.getEmployeeNumber());
//      System.out.println(employee1.getEmployeeFirstName());
//      System.out.println(employee1.getEmployeeLastName());
//      System.out.println(employee1.getEmployeeTitle());
//      System.out.println(employee1.getEmployeeEmail());
//      
//      
////      om.writeValueAsString(employee1)
////      resp.getWriter().write(om.writeValueAsString(employee1));
//  }
  
  @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    System.out.println("Received " + req.getMethod() + " at " + req.getRequestURI());
    String employeeId = req.getParameter("employeeNum");
//    EmployeeModel employeeReq = om.readValue(req.getReader(), EmployeeModel.class);
//    System.out.println("received Employee: " + employeeReq);
    System.out.println(employeeId);
    resp.getWriter().write("Received Employee: " + employeeId);
    }
  

}
