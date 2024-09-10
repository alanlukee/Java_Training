package Vehicle_Rental_System;

public class ElectricScooter implements Rentable {
	
	String scooterId;
	String brand;
	int batteryCapacity;
	double baseRent ;
	

	@Override
	public double calculateRent(int days) {
		double rent = days * baseRent * (batteryCapacity > 20 ? 1.3 : 1.0);
		return rent;
	}

	@Override
	public void displayDetails() {
		System.out.println("Scooter Id: "+scooterId);
		System.out.println("Brand: "+brand);
		System.out.println("batteryCapacity: "+batteryCapacity);
		System.out.println("baseRent: "+baseRent);
		
		
	}

}
