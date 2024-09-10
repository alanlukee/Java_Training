package Car_Rental_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
        RentalCostCalculator calc = new RentalCostCalculator();

        System.out.println("Enter type of car (economy/midsize/luxury): ");
        String carType = scan.nextLine().trim().toLowerCase();

        System.out.println("Enter rental duration (in days): ");
        int duration = scan.nextInt();
        scan.nextLine();
        System.out.println("Insurance included? (yes/no): ");
        String insu = scan.nextLine();
        System.out.print("Do you want additional features (rear view camera/heated seats/gps)? (Enter comma-separated): ");
        
        String features = scan.nextLine();
        scan.close();
        
        List<String> additionalFeatures = new ArrayList<>();
        
        if (!features.isEmpty()) {
            String[] featuresArray = features.split(",");
            for (String feature : featuresArray) {
                additionalFeatures.add(feature);
            }
        }
        
        double totCost = 0;
        
        
        if (additionalFeatures.isEmpty() && insu.equals("yes")) {
        	totCost = calc.calculateRentalCost(carType, duration, true);
        }
        else if (additionalFeatures.isEmpty() && insu.equals("no")) {
        	totCost = calc.calculateRentalCost(carType, duration, false);
        }
        else if (!additionalFeatures.isEmpty() && insu.equals("yes")) {
        	
        	totCost = calc.calculateRentalCost(carType, duration, true, additionalFeatures);
        	
        }
        else if (!additionalFeatures.isEmpty() && insu.equals("no")) {
        	
        	totCost = calc.calculateRentalCost(carType, duration, false, additionalFeatures);
        	
        }
        else {
        	System.out.println("invalid");
        }
        
        
        System.out.println(" ");
        System.out.println("Rent Calculator");
        System.out.println("---------------------");
        System.out.println("Car Type: " + carType);
        System.out.println("Rental Duration: " + duration + " days");
        
        if (insu.equals("yes")) {
        	System.out.println("Insurance Included: Yes" );
        }
        else {
        	System.out.println("Insurance Included: No" );
        }
        if (!additionalFeatures.isEmpty()) {
            System.out.println("Additional Features: " + String.join(",", additionalFeatures));
        } else {
            System.out.println("Additional Features: None");
        }
        
        System.out.println("Total rental cost: "+totCost+" rupees");
        
        

	}

}
