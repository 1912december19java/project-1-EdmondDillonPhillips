package com.revature.models;

public class ReimbursementModel {
	
	
	private String employeeFirstName;
	private String amountRequested;
	private String purposeForRequest;
	private String employeeNumber;
	
	
	
	public ReimbursementModel(String employeeFirstName, String amountRequested, String purposeForRequest,
			String employeeNumber) {
		super();
		this.employeeFirstName = employeeFirstName;
		this.amountRequested = amountRequested;
		this.purposeForRequest = purposeForRequest;
		this.employeeNumber = employeeNumber;
	}
	

	public ReimbursementModel(String employeeNumber) {
		super();
		this.employeeNumber = employeeNumber;
	}

	public ReimbursementModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getAmountRequested() {
		return amountRequested;
	}
	public void setAmountRequested(String amountRequested) {
		this.amountRequested = amountRequested;
	}
	public String getPurposeForRequest() {
		return purposeForRequest;
	}
	public void setPurposeForRequest(String purposeForRequest) {
		this.purposeForRequest = purposeForRequest;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

}
