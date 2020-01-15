package com.revature.repository;

import com.revature.models.EmployeeModel;

public interface EmployeeDao {

  EmployeeModel get(String employeeNumber);
  
//  EmployeeModel get(String employeeNumber, String employeeFirstName, String employeeLastName,
//                    String employeeEmail, String employeeTitle, String reportsTo);
  
}
