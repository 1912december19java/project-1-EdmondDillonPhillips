package com.revature.services;

import java.util.List;

import com.revature.models.EmployeeModel;
import com.revature.models.ManagerModel;
import com.revature.repository.EmployeeDao;
import com.revature.repository.ManagerDao;

public class ManagerService {

	private ManagerDao managerDao;
	
	public ManagerService(ManagerDao managerDao) {
		
		this.managerDao = managerDao;
	}
	
	public ManagerModel get(String managerNumber) {
		System.out.println("Hello From Employee Service get()");
		System.out.println(managerNumber);
		return managerDao.get(managerNumber);
	}
	
	public List<ManagerModel> getAll(){
		System.out.println("Hello From Employee Service getAll()");

		return managerDao.getAll();
	}
	
	public void save(ManagerModel managerNumber) {
		System.out.println("Hello From Employee Service save()");

		managerDao.save(managerNumber);
	}
	
	public void update(ManagerModel managerNumber) {
		System.out.println("Hello From Employee Service update()");

		managerDao.update(managerNumber);
	}
}
