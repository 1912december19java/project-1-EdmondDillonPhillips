package com.revature.repository;

import java.util.List;

import com.revature.models.ReimbursementModel;

public interface PendingDao {

	ReimbursementModel get(String pendingReceipt);

	List<ReimbursementModel> getAll();

	void save(ReimbursementModel pendingRequest);

	void update(ReimbursementModel pendingReceipt);

	

}
