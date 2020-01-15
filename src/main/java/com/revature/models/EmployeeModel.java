package com.revature.models;

public class EmployeeModel {
  
  private String employeeNumber;
  private String employeeFirstName;
  private String employeeLastName;
  private String employeeEmail;
  private String employeeTitle;
  private String reportsTo;
  //maybe pendingReimbursements;
  //maybe resolvedReimbursements;
  
  /**
   * Constructor for the EmployeeModel
   * @param employeeNumber
   * @param firstName
   * @param lastName
   * @param email
   * @param title
   * @param reportsTo
   */
  
  
  public EmployeeModel(String employeeNumber, String firstName, String lastName, String email,
      String title, String reportsTo) {
    super();
    this.employeeNumber = employeeNumber;
    this.employeeFirstName = firstName;
    this.employeeLastName = lastName;
    this.employeeEmail = email;
    this.employeeTitle = title;
    this.reportsTo = reportsTo;
  }
  
  public EmployeeModel(String employeeNumber) {
    super();
    this.employeeNumber = employeeNumber;
  }

  
  //Getters and Setters for the EmployeeModel

  public String getEmployeeNumber() {
    return employeeNumber;
  }


  public void setEmployeeNumber(String employeeNumber) {
    this.employeeNumber = employeeNumber;
  }


  public String getEmployeeFirstName() {
    return employeeFirstName;
  }


  public void setEmployeeFirstName(String employeeFirstName) {
    this.employeeFirstName = employeeFirstName;
  }


  public String getEmployeeLastName() {
    return employeeLastName;
  }


  public void setEmployeeLastName(String employeeLastName) {
    this.employeeLastName = employeeLastName;
  }


  public String getEmployeeEmail() {
    return employeeEmail;
  }


  public void setEmail(String employeeEmail) {
    this.employeeEmail = employeeEmail;
  }


  public String getEmployeeTitle() {
    return employeeTitle;
  }


  public void setTitle(String employeeTitle) {
    this.employeeTitle = employeeTitle;
  }


  public String getReportsTo() {
    return reportsTo;
  }


  public void setReportsTo(String reportsTo) {
    this.reportsTo = reportsTo;
  }
  
}
