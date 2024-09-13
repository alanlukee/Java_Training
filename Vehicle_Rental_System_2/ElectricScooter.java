package Vehicle_Rental_System_2;

public class ElectricScooter implements Rentable {
	
	String scooterId;
	String brand;
	int batteryCapacity;
	double baseRent;
	
	public ElectricScooter(String scooterId, String brand, int batteryCapacity, double baseRent) {
		
		this.scooterId = scooterId;
		this.brand = brand;
		this.batteryCapacity = batteryCapacity;
		this.baseRent = baseRent;
		
	}
	@Override
	public double calculateRent(int days) {
		// TODO Auto-generated method stub
		
		double rent = days * baseRent * (batteryCapacity > 20 ? 1.3 : 1.0);
		return rent;
	}

	@Override
	public void displayDetails() {
		// TODO Auto-generated method stub
		System.out.println("scooter id: "+scooterId);
		System.out.println("brand: "+brand);
		System.out.println("batteryCapacity: "+batteryCapacity);
		System.out.println("baserent: "+baseRent);
		
	}

}
