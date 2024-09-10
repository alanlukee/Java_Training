package Vehicle_Rental_System;

public abstract class Vehicle implements Rentable {
	
	String vehicleId;
	String brand;
	String model;
	double baseRent;
	
	public void displayDetails() {
		System.out.println("Vehicle Id: "+vehicleId);
		System.out.println("Brand: "+brand);
		System.out.println("Model: "+model);
		
	}
	public abstract double calculateRent(int days);

}
