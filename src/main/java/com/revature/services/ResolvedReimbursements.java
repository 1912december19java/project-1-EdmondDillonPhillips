package com.revature.services;

import java.util.List;

import com.revature.models.ReimbursementModel;
import com.revature.repository.PendingDao;
import com.revature.repository.ResolvedDao;

public class ResolvedReimbursements {

	private ResolvedDao resolvedDao;
	
	public ResolvedReimbursements(ResolvedDao resolvedDao) {
		
		this.resolvedDao = resolvedDao;
	}
	
	public ReimbursementModel get(String resolvedReceipt) {
		System.out.println("Hello From Resolved Reimbursment get()");
		return resolvedDao.get(resolvedReceipt);
	}
	
	public List<ReimbursementModel> getAll(){
		System.out.println("Hello From Resolved Reimbursment getAll()");

		return resolvedDao.getAll();
	}
	
	public void save(ReimbursementModel resolvedReceipt) {
		System.out.println("Hello From Resolved Reimbursment save()");

		resolvedDao.save(resolvedReceipt);
	}
	
	public void update(ReimbursementModel resolvedReceipt) {
		System.out.println("Hello From Resolved Reimbursment update()");

		resolvedDao.update(resolvedReceipt);
	}
}
