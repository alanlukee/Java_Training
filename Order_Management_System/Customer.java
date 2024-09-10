package Order_Management_System;

public abstract class Customer {
	int customerId;
	
	Customer(int customerId){
		this.customerId = customerId;
	}
	
	public abstract double getDiscountRate();

}
