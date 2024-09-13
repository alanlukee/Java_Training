package Vehicle_Rental_System_2;

public class Truck extends Vehicle {
	
	int loadCapacity;

	Truck(String vehicle_ID, String brand, String model,int baseRent) {
		super(vehicle_ID, brand, model, baseRent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateRent(int days) {
		
		double rent = days * baseRent * (loadCapacity > 5 ? 1.5 : 1.2);
		return rent;
	}

}
