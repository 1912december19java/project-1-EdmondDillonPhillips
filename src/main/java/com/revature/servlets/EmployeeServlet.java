package com.revature.servlets;

import java.io.IOException;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.repository.EmployeeDao;
import com.revature.repository.EmployeeDaoPostgres;

@WebServlet(name="Employees", urlPatterns= {"/employee"})
public class EmployeeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
      

    
      EmployeeDao employeeDao = new EmployeeDaoPostgres();
      
      System.out.println("Hello From Servlet");
      System.out.println(employeeDao.get("E001"));
      
  }
  
}
