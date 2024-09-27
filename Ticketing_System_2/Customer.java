package Ticketing_System_2;

public abstract class Customer {
	
	String customerType;
	
	Customer(String customerType){
		
		this.customerType = customerType;
	}
	
	abstract double getDiscount();
	

}
