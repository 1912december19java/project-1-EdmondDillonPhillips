package com.revature.repository;

import java.util.List;

import com.revature.models.EmployeeModel;

public interface EmployeeDao {

  EmployeeModel get(String employeeNumber);
  
  List<EmployeeModel> getAll();
  
  void save(EmployeeModel employee);
  
  void update(EmployeeModel employee);
  
//  EmployeeModel get(String employeeNumber, String employeeFirstName, String employeeLastName,
//                    String employeeEmail, String employeeTitle, String reportsTo);
  
}