package Order_Management_System;

public class CorporateCustomer extends Customer {
	private double corporateCustomerRate = 0.15;

	CorporateCustomer(int customerId) {
		super(customerId);
		
	}

	@Override
	public double getDiscountRate() {
		
		return corporateCustomerRate;
	}

}
