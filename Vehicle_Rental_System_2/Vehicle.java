package Vehicle_Rental_System_2;

public abstract class Vehicle implements Rentable {
	
	String vehicle_ID;
	String brand;
	String model;
	double baseRent;
	
	Vehicle(String vehicle_ID, String brand, String model,double baseRent){
		
		this.vehicle_ID = vehicle_ID;
		this.brand = brand;
		this.model = model;
		this.baseRent = baseRent;
	}
	
	@Override
	public abstract double calculateRent(int days);

	@Override
	public void displayDetails() {
		System.out.println("Vehicle Id: "+vehicle_ID);
		System.out.println("Brand: "+brand);
		System.out.println("Model: "+model);
		System.out.println("Base Rent: "+baseRent);
		
	}
	

}
