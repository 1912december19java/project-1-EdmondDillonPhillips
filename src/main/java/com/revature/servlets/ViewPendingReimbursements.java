package com.revature.servlets;

import java.io.IOException;
import java.net.http.HttpClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementModel;
import com.revature.repository.PendingDaoPostgres;
import com.revature.services.PendingReimbursements;

@WebServlet(name="CreatePendingReimbursementServlet", urlPatterns= {"/viewpendingreimbursement"})
public class ViewPendingReimbursements extends HttpServlet {


	  private PendingReimbursements reimbursementService;
	  private ObjectMapper om;

	  
	  @Override
	  public void init() throws ServletException {
	    this.reimbursementService =  new PendingReimbursements(new PendingDaoPostgres());
	    this.om = new ObjectMapper();
	    
	    super.init();
	  }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("A request was made to " + req.getMethod() + " at " + req.getRequestURL());
		ReimbursementModel reimbursementRequestData = om.readValue(req.getReader(), ReimbursementModel.class);
		System.out.println(reimbursementRequestData);



	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("A request was made to " + req.getMethod() + " at " + req.getRequestURL());
		ReimbursementModel reimbursementRequestData = om.readValue(req.getReader(), ReimbursementModel.class);
		System.out.println(reimbursementRequestData);


	}
}
