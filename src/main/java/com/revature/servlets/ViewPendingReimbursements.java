package com.revature.servlets;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

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
//		ReimbursementModel reimbursementRequestData = om.readValue(req.getReader(), ReimbursementModel.class);
//		System.out.println(reimbursementRequestData);
		
		List<ReimbursementModel> allPendingRequests = reimbursementService.getAll();
//		List<ReimbursementModel> filteredRequests;
		 System.out.println("test");
//		// iterate via "for loop"
//				System.out.println("==> For Loop Example.");
//				for (int i = 0; i < allPendingRequests.size(); i++) {
//					if(allPendingRequests.get(i).getEmployeeNumber().equals(reimbursementRequestData.getEmployeeNumber()) ) {
//						filteredRequests.add(allPendingRequests.get(i));
//						
//					}
//					
//				}
		 System.out.println(allPendingRequests);
		 System.out.println(om.writeValueAsString(allPendingRequests));
		 
		 resp.getWriter().write(om.writeValueAsString(allPendingRequests));


	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("A request was made to " + req.getMethod() + " at " + req.getRequestURL());
		ReimbursementModel reimbursementRequestData = om.readValue(req.getReader(), ReimbursementModel.class);
		System.out.println(reimbursementRequestData);
		
		List<ReimbursementModel> allPendingRequests = reimbursementService.getAll();
//		List<ReimbursementModel> filteredRequests;
		 
//		// iterate via "for loop"
//				System.out.println("==> For Loop Example.");
//				for (int i = 0; i < allPendingRequests.size(); i++) {
//					if(allPendingRequests.get(i).getEmployeeNumber().equals(reimbursementRequestData.getEmployeeNumber()) ) {
//						filteredRequests.add(allPendingRequests.get(i));
//						
//					}
//					
//				}
		 System.out.println(allPendingRequests);
		 System.out.println(om.writeValueAsString(allPendingRequests));
		 
		 resp.getWriter().write(om.writeValueAsString(allPendingRequests));



	}
}
