package com.revature.services;

import java.util.List;

import com.revature.models.EmployeeModel;
import com.revature.models.ReimbursementModel;
import com.revature.repository.EmployeeDao;
import com.revature.repository.PendingDao;

public class PendingReimbursements {

	
	private PendingDao pendingDao;
	
	public PendingReimbursements(PendingDao pendingDao) {
		
		this.pendingDao = pendingDao;
	}
	
	public ReimbursementModel get(String pendingReceipt) {
		System.out.println("Hello From Employee Service get()");
		return pendingDao.get(pendingReceipt);
	}
	
	public List<ReimbursementModel> getAll(){
		System.out.println("Hello From Employee Service getAll()");

		return pendingDao.getAll();
	}
	
	public void save(ReimbursementModel pendingRequest) {
		System.out.println("Hello From Employee Service save()");

		pendingDao.save(pendingRequest);
	}
	
	public void update(ReimbursementModel pendingReceipt) {
		System.out.println("Hello From Employee Service update()");

		pendingDao.update(pendingReceipt);
	}

	
}
