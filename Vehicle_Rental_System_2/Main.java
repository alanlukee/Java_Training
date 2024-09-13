package Vehicle_Rental_System_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	
		ElectricScooter es = new ElectricScooter("kl02", "ather", 1500, 345);
		Car c = new Car("kl03", "benz", "gla",45);
		c.hasAirConditioner = true;
		Bike b = new Bike("kl04", "royal enfield", "xy1",567);
		b.engineCapacity = 200;
		Truck t = new Truck("kl05", "bharatbenz", "a02",778);
		t.loadCapacity = 500;
		
		Scanner scan = new Scanner(System.in);

		
		System.out.println("Details of vehicles in garage:");
		System.out.println(" ");
		es.displayDetails();
		System.out.println(" ");
		c.displayDetails();
		System.out.println(" ");
		b.displayDetails();
		System.out.println(" ");
		t.displayDetails();
		System.out.println(" ");

	
		System.out.println("enter vehicles you require: ElectricScooter,Car,Bike,Truck (comma sep) ");
		String vehicleString = scan.nextLine();
		
		String[] vehicleArray = vehicleString.split(",");
		
		List<String> vehicleList = new ArrayList<>();

		
		for(String i : vehicleArray) {
			vehicleList.add(i.trim());
		}
		
	
		List<Rentable> vehicleObjects = new ArrayList<>();
		
		if(vehicleList.contains("ElectricScooter")) {
			vehicleObjects.add(es);
		}
		if(vehicleList.contains("Car")) {
			vehicleObjects.add(c);

		}
		if(vehicleList.contains("Bike")) {
			vehicleObjects.add(b);

		}
		if(vehicleList.contains("Truck")){
			vehicleObjects.add(t);

		}
		
		System.out.println("vehicles selected for rent are: ");
		System.out.println(" ");

		
		for(Rentable i :vehicleObjects ) {
			
			i.displayDetails();
			
			System.out.println("Rent: "+i.calculateRent(4));
			System.out.println(" ");
		}
		
		System.out.println("Calculating total rent...");
		int totalRent = 0;
		for(Rentable i :vehicleObjects ) {
			
			totalRent =(int) (totalRent+ i.calculateRent(4));
			
		}
		
		System.out.println("Total rent: "+totalRent+" rupees");
		
	
	}

}
