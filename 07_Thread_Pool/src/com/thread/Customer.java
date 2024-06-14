package com.thread;

public class Customer {

	String customerName;
	String policyNumber;
	String message;
	Double premium;
	
	
	public Customer(String customerName, String policyNumber, Double premium) {
		super();
		this.customerName = customerName;
		this.policyNumber = policyNumber;
		this.premium = premium;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Double getPremium() {
		return premium;
	}
	public void setPremium(Double premium) {
		this.premium = premium;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", policyNumber=" + policyNumber + ", message=" + message
				+ ", premium=" + premium + "]";
	}
	

	
}
