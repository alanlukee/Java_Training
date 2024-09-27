package Vehicle_Rental_System;

public class Car extends Vehicle{
	
	boolean hasAirConditioner;

	@Override
	public double calculateRent(int days) {
		
		double rent = (int) (days * baseRent * (hasAirConditioner ? 1.2 : 1.0));
		return rent;
	}

}
