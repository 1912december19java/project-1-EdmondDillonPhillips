package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.ReimbursementModel;

public class PendingDaoPostgres implements PendingDao {

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

	  };
	
	@Override
	public ReimbursementModel get(String employeeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ReimbursementModel pendingRequest) {
		System.out.println("Hello from the reimbursement save()");
	    PreparedStatement stmt = null;
	    String employeeNo = pendingRequest.getEmployeeNumber();
		String employeeFirstName = pendingRequest.getEmployeeFirstName();
		String amountRequested = pendingRequest.getAmountRequested();
	    String purposeForRequest = pendingRequest.getPurposeForRequest();


	    System.out.println("Hello from EmployeeDaoPostgres update()");
	    try {
	      stmt = conn.prepareStatement(
	    		  "INSERT INTO pendingreimbursements (employee_first_name, amount_requested, purpose, employee_id) VALUES (?, ?, ?, ?)");
	      
	      stmt.setString(1, employeeFirstName);
	      stmt.setString(2, amountRequested);
	      stmt.setString(3, purposeForRequest);
	      stmt.setString(4, employeeNo);


	      stmt.execute();

	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		
	}

	@Override
	public void update(ReimbursementModel employee) {
		// TODO Auto-generated method stub
		
	}

}
