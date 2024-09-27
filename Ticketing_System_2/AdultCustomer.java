package Ticketing_System_2;

public class AdultCustomer extends Customer {

	AdultCustomer(String customerType) {
		super(customerType);
	}

	@Override
	double getDiscount() {
		return 0;
	}

}
