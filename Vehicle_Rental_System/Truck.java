package Vehicle_Rental_System;

public class Truck extends Vehicle {
	
	int loadCapacity;

	@Override
	public double calculateRent(int days) {
		double rent = days * baseRent * (loadCapacity > 5 ? 1.5 : 1.2);
		return rent;
	}

}
