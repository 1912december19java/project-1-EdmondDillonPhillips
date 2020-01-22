package com.revature.services;

import java.util.List;

import com.revature.models.EmployeeModel;
import com.revature.repository.EmployeeDao;

public class EmployeeLogin implements EmployeeDao {
	
	private EmployeeDao employeeDao;
	
	public EmployeeLogin(EmployeeDao employeeDao) {
		
		this.employeeDao = employeeDao;
	}
	
	public EmployeeModel get(String employeeNumber) {
		
		return employeeDao.get(employeeNumber);
	}
	
	public List<EmployeeModel> getAll(){
		System.out.println("Hello From Employee Service getAll()");

		return employeeDao.getAll();
	}
	
	public void save(EmployeeModel employee) {
		System.out.println("Hello From Employee Service save()");

		employeeDao.save(employee);
	}
	
	public void update(EmployeeModel employee) {
		System.out.println("Hello From Employee Service update()");

		employeeDao.update(employee);
	}
	
//===================================================================================================


}
