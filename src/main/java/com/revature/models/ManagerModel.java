package com.revature.models;

public class ManagerModel {
  
  private String managerNumber;
  private String managerFirstName;
  private String managerLastName;
  private String managerEmail;
  private String managerTitle;
  //maybe pendingReimbursementRequests
  //maybe resolvedReimbursementRequests
  
  /**
   * Constructor for the MangerModel
   * @param managerNumber
   * @param managerFirstName
   * @param managerLastName
   * @param managerEmail
   * @param managerTitle
   */
  
  
  public ManagerModel(String managerNumber, String managerFirstName, String managerLastName,
      String managerEmail, String managerTitle) {
    super();
    this.managerNumber = managerNumber;
    this.managerFirstName = managerFirstName;
    this.managerLastName = managerLastName;
    this.managerEmail = managerEmail;
    this.managerTitle = managerTitle;
  }

  

}
