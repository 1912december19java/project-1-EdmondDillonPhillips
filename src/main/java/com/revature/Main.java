package com.revature;

import com.revature.models.EmployeeModel;
import com.revature.repository.EmployeeDao;
import com.revature.repository.EmployeeDaoPostgres;

public class Main {

  //The main user interface will go here... maybe...
  
  public static void main(String[] args) {
    
    EmployeeDao employeeDao = new EmployeeDaoPostgres();
    
    EmployeeModel employee1 = employeeDao.get("E002");
    


    
    System.out.println(employee1.getEmployeeNumber());
    System.out.println(employee1.getEmployeeFirstName());
    System.out.println(employee1.getEmployeeLastName());
    System.out.println(employee1.getEmployeeTitle());
    System.out.println(employee1.getEmployeeEmail());
//    
//    emp.Connection();

    
//    ComicDao comicDao = new ComicDaoPostgres();
//    
//    Comic comic2 =  comicDao.get(2);
//    Comic comic3 = comicDao.get(3);
//    Comic comic70 = comicDao.get(70);
//    Comic comic60 = comicDao.get(-33);
}
  
}