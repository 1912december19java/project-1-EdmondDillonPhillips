package com.revature.models;

public class ManagerModel {

	
	  private String managerNumber;
	  private String managerFirstName;
	  private String managerLastName;
	  private String managerEmail;
	  private String managerTitle;
	  
	public ManagerModel(String managerNumber, String managerFirstName, String managerLastName, String managerEmail,
			String managerTitle) {
		super();
		this.managerNumber = managerNumber;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.managerEmail = managerEmail;
		this.managerTitle = managerTitle;
	}
	
	


	public ManagerModel(String managerNumber, String managerFirstName, String managerLastName, String managerEmail) {
		super();
		this.managerNumber = managerNumber;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.managerEmail = managerEmail;
	}




	public ManagerModel(String managerNumber) {
		super();
		this.managerNumber = managerNumber;
	}



	public ManagerModel() {
		super();
	}


	public String getManagerNumber() {
		return managerNumber;
	}

	public void setManagerNumber(String managerNumber) {
		this.managerNumber = managerNumber;
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getManagerTitle() {
		return managerTitle;
	}

	public void setManagerTitle(String managerTitle) {
		this.managerTitle = managerTitle;
	}
	
	
	  
	  
	  
}
