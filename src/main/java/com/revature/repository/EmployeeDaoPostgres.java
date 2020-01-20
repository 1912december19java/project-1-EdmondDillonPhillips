package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.repository.EmployeeDao;

import com.revature.models.EmployeeModel;

public class EmployeeDaoPostgres implements EmployeeDao {
  

  private static Connection conn;

    
  static {
    // This explicitly loads the Driver class:
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    }
    try {
      conn = DriverManager.getConnection(
          System.getenv("connstring"), System.getenv("username"), System.getenv("password"));
      System.out.println(conn);
//      log.info("Connected to Database");
    } catch (SQLException e) {
//      log.error("Failed to connect to database", e);
    }

  };
  
  
  //Returns the object "out which has the information collected from the database"
  @Override
  public EmployeeModel get(String employeeNumber) {
//    log.info("Attempting to get User with username: " + employeeNumber);
    EmployeeModel out = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    System.out.println("Hello from EmployeeDaoPostgress get() method");
    System.out.println(conn);


    try {
      stmt = conn.prepareStatement("SELECT * FROM Employees WHERE employee_id = ?");
      // 1 is the index of the ?
      stmt.setString(1, employeeNumber);
      
      // Now our statement is ready to go. Lets run it.
      if (stmt.execute()) {
        // Now we have some results. Lets get them.
        rs = stmt.getResultSet();

      }
      // This line is typical, but not particularly useful for our 1-line rs
      while (rs.next()) {
        out = new EmployeeModel(rs.getString("employee_id"), rs.getString("employee_first_name"), rs.getString("employee_last_name"),
                                rs.getString("employee_email"), rs.getString("employee_title"), rs.getString("manager_id"));
      }
    } catch (SQLException e) {
//      log.error("Failed to retrieve employee with Employee Number: " + employeeNumber, e );
    }
    
//    System.out.println(out.getEmployeeNumber());
    System.out.println("Result from DB query");
    System.out.println(out);
    return out;
  }
  
  @Override
  public List<EmployeeModel> getAll() {
	  
	    EmployeeModel out = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    System.out.println("Hello from EmployeeDaoPostgres getAll() method");
	    System.out.println(conn);
	  
	  
	return null;
	  
  }
  
  @Override
  public void save(EmployeeModel employee) {
	  
	    EmployeeModel out = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    System.out.println("Hello from EmployeeDaoPostgres save() method");
	    System.out.println(conn);
  }
  @Override
  public void update(EmployeeModel employee) {
	    PreparedStatement stmt = null;
	    System.out.println("Hello from EmployeeDaoPostgres update()");
	    try {
	      stmt = conn.prepareStatement(
	          "UPDATE Employees SET employee_first_name = ?, employee_last_name = ?, employee_email = ? WHERE employee_id = ?");
	      
	      stmt.setString(1, employee.getEmployeeFirstName());
	      stmt.setString(2, employee.getEmployeeLastName());
	      stmt.setString(3, employee.getEmployeeEmail());
	      
	      stmt.setString(4, employee.getEmployeeNumber());

	      stmt.execute();

	    } catch (SQLException e) {
//	      e.printStackTrace();
//	      throw new InvalidComicException(e);
	    }
  }


//  @Override
//  public EmployeeModel get(String employeeNumber, String employeeFirstName, String employeeLastName,
//      String employeeEmail, String employeeTitle, String reportsTo) {
//    // TODO Auto-generated method stub
//    return null;
//  }

}
