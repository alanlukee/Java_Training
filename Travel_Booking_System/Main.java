package Travel_Booking_System;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("unused")
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		double moderateperkm = 0;
		
		System.out.println("Enter traveller name: ");
		String travellerName = scan.nextLine();
		System.out.println("Enter total distance to travel(in kms): ");
		double distance = scan.nextDouble();
		System.out.println("Enter base fare per km: ");
		double fareperkm = scan.nextDouble();
		System.out.println("Enter discount(in %): ");
		double discount = scan.nextDouble();
		System.out.println("Enter travel mode(flight/train/bus): ");
		String mode = scan.next();
		scan.close();
		
		FareCalculator calc = new FareCalculator();
		
		if(mode.toLowerCase().equals("flight")) {
			
			Travel flight = new FlightTravel();
			moderateperkm = flight.getBaseFarePerKm();
		}
		else if (mode.toLowerCase().equals("bus")){
			Travel bus = new BusTravel();
			moderateperkm = bus.getBaseFarePerKm();
			
		}
		else if (mode.toLowerCase().equals("train")){
			Travel train = new TrainTravel();
			moderateperkm = train.getBaseFarePerKm();

	}
		else {
			System.out.println("invalid mode");
		}
		
		System.out.println("Hey "+travellerName+ "! Welcome to Travel Booking System");
		System.out.println("-----------------------------------------------------------");
		System.out.println("Travel mode choosen: "+mode);
		System.out.println("Distance to travel: "+distance+" km");
		System.out.println("Discount rate and base rate per km : "+ discount+"% and "+ moderateperkm+ " rupees respectively");
		System.out.println("Cost before applying discount and mode rate: "+calc.calculateFare(distance, moderateperkm)+" rupees");
		System.out.println("Final total fare: "+calc.calculateFare(distance, moderateperkm, discount, mode)+" rupees");
			
		
	}
}
