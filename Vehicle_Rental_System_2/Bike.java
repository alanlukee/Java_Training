package Vehicle_Rental_System_2;

public class Bike extends Vehicle {
	
	Bike(String vehicle_ID, String brand, String model,int baseRent) {
		super(vehicle_ID, brand, model, baseRent);
		// TODO Auto-generated constructor stub
	}

	int engineCapacity;

	@Override
	public double calculateRent(int days) {
		
		double rent = days * baseRent * (engineCapacity > 150 ? 1.1 : 1.0);
		return rent;
	}
	

}
