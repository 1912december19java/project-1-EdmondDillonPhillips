package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.EmployeeModel;
import com.revature.models.ManagerModel;

public class ManagerDaoPostgres implements ManagerDao {

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
//	      log.info("Connected to Database");
	    } catch (SQLException e) {
//	      log.error("Failed to connect to database", e);
	    }

	  }

		@Override
		public ManagerModel get(String managerNumber) {
//		    log.info("Attempting to get User with username: " + employeeNumber);
			ManagerModel out = null;
		    PreparedStatement stmt = null;
		    ResultSet rs = null;
		    System.out.println("Hello from ManagerDaoPostgress get() method");
		    System.out.println(conn);


		    try {
		      stmt = conn.prepareStatement("SELECT * FROM Managers WHERE manager_id = ?");
		      // 1 is the index of the ?
		      stmt.setString(1, managerNumber);
		      
		      // Now our statement is ready to go. Lets run it.
		      if (stmt.execute()) {
		        // Now we have some results. Lets get them.
		        rs = stmt.getResultSet();

		      }
		      // This line is typical, but not particularly useful for our 1-line rs
		      while (rs.next()) {
		        out = new ManagerModel(rs.getString("manager_id"), rs.getString("manager_first_name"), rs.getString("manager_last_name"), rs.getString("manager_email"));
		      }
		    } catch (SQLException e) {
//		      log.error("Failed to retrieve employee with Employee Number: " + employeeNumber, e );
		    }
		    
//		    System.out.println(out.getEmployeeNumber());
		    System.out.println("Result from Manager DB query");
		    System.out.println(out);
		    return out;
		}


		@Override
		public List<ManagerModel> getAll() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public void save(ManagerModel managerNumber) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void update(ManagerModel managerNumber) {
			// TODO Auto-generated method stub
			
		};
		  


}
