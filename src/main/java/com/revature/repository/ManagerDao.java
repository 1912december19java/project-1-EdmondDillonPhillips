package com.revature.repository;

import java.util.List;

import com.revature.models.ManagerModel;

public interface ManagerDao {

	ManagerModel get(String managerNumber);

	List<ManagerModel> getAll();

	void save(ManagerModel managerNumber);

	void update(ManagerModel managerNumber);

}
