package E_Commerce_System;

public class Customer {
	
	private int customerId; 
	private String name; 
	private String email;
	
	Customer(int customerId, String name, String email){
		
		this.customerId=customerId;
		this.name=name;
		this.email=email;
		
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void printCustomerDetails() {
        System.out.println("Customer Details:");
        System.out.println("ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
	}
	
	

}
