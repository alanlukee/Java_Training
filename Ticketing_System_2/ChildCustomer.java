package Ticketing_System_2;

public class ChildCustomer extends Customer {

	ChildCustomer(String customerType) {
		super(customerType);
	}

	@Override
	double getDiscount() {
		return 0.5;
	}

}
