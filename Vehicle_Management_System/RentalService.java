package Vehicle_Management_System;

public class RentalService {
	
	public double calculateRentalCost(int duration,double baseRate ) {
		
		return (duration*baseRate);
		
	}
	
	public void calculateRentalCost(int duration,double baseRate, String feature ) {
	

        double additionalCost = 0;

        if (feature.equals("GPS")) {
            additionalCost = 55; 
        } else if (feature.equals("Child Seat")) {
            additionalCost = 25; 
        }
        
        double rate = ((duration * baseRate) + (duration * additionalCost));
        System.out.println("Duration: " + duration + " days");
        System.out.println("Base Rate: " + baseRate);
        System.out.println("Feature: " + feature );
        System.out.println("Total Cost: " + rate);

        //return (duration * baseRate) + (duration * additionalCost);
		
		
	}
//	public int calculateRentalCost(int duration,double baseRate, String feature, String vehicleType ) {
//		
//		return 0;
//		
//	}

}
