package Ticketing_System_2;

public class SeniorCustomer extends Customer {

	SeniorCustomer(String customerType) {
		super(customerType);
	}

	@Override
	double getDiscount() {
		return 0.2;
	}

}
