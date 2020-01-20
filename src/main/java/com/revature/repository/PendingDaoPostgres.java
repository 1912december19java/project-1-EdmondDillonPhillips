package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
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
	public void save(ReimbursementModel employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ReimbursementModel employee) {
		// TODO Auto-generated method stub
		
	}

}
