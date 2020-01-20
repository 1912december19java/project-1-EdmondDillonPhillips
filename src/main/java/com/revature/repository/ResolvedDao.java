package com.revature.repository;

import java.util.List;

import com.revature.models.ReimbursementModel;

public interface ResolvedDao {

	ReimbursementModel get(String resolvedReceipt);

	List<ReimbursementModel> getAll();

	void save(ReimbursementModel resolvedReceipt);

	void update(ReimbursementModel resolvedReceipt);

}
