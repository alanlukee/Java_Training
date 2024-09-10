package Vehicle_Rental_System;

public class Bike extends Vehicle {
	
	int engineCapacity;

	@Override
	public double calculateRent(int days) {
		double rent = days * baseRent * (engineCapacity > 150 ? 1.1 : 1.0);
		return rent;
	}

}
