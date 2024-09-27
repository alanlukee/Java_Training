package Vehicle_Management_System;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("input rental duration: ");
		int duration = scan.nextInt();
		System.out.println("input additional feature(GPS/Child Seat): ");
		String feature = scan.next();
		System.out.println("enter vehicle type(Car/Truck/Bike): ");
		String vehicleType = scan.next();
		
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle truck = new Truck();
        
        double carRate = car.getRentalRate();
        double bikeRate = bike.getRentalRate();
        double truckRate = truck.getRentalRate();
        
        RentalService rent = new RentalService();
        
        if (vehicleType.equals("Car")) {
            rent.calculateRentalCost(duration, carRate, feature);
        } else if (vehicleType.equals("Bike")) {
            rent.calculateRentalCost(duration, bikeRate, feature);
        } else if (vehicleType.equals("Truck")) {
            rent.calculateRentalCost(duration, truckRate, feature);
        }


	}

}
