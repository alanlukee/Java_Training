package Order_Management_System;

public class RegularCustomer extends Customer {
	
	private double regularCustomerRate = 0.05;

	RegularCustomer(int customerId) {
		super(customerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getDiscountRate() {
		
		return regularCustomerRate;
	}

}
