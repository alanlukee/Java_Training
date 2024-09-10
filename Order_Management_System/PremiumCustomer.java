package Order_Management_System;

public class PremiumCustomer extends Customer {
	private double premiumCustomerRate = 0.1;

	PremiumCustomer(int customerId) {
		super(customerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getDiscountRate() {
		
		return premiumCustomerRate ;
	}

}
