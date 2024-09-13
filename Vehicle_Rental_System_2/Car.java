package Vehicle_Rental_System_2;

public class Car extends Vehicle {
	
	Car(String vehicle_ID, String brand, String model,int baseRent) {
		super(vehicle_ID, brand, model, baseRent);
		// TODO Auto-generated constructor stub
	}

	boolean hasAirConditioner;

	@Override
	public double calculateRent(int days) {
		
		double rent = (int) (days * baseRent * (hasAirConditioner ? 1.2 : 1.0));
		return rent;
		
	}

}
