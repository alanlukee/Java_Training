package Logistics_Management_System;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
        Scanner scan = new Scanner(System.in);
        System.out.println("Shipping Cost Calculator --->");
        System.out.println(" ");
        
        
        System.out.println("Enter weight of package (in kg): ");
        double weight = scan.nextDouble();
       
        scan.nextLine();
        
        System.out.println("Enter the distance to destination (in km): ");
        double dist = scan.nextDouble();
        
        scan.nextLine();
        
        System.out.println("Enter type of package (express/international/standard): ");
        String ptype = scan.nextLine();
        
        System.out.println("Enter package priority (true/false): ");
        boolean packagePriority = scan.nextBoolean();
        
        scan.nextLine();
        
        System.out.println(" ");
		
		
		ShippingCostCalculator calc = new ShippingCostCalculator();
		
		double totCost = calc.calculateShippingCost(weight, dist, packagePriority, ptype);
		
		Package pack;
		if(ptype.equals("express")) {
			pack = new ExpressPackage();
		}
		else if (ptype.equals("international")) {
			pack = new InternationalPackage();
		}
		else {
			pack = new StandardPackage();
		}
		
		System.out.println("Shipping cost breakdown ---->");
		System.out.println(" ");
		System.out.println("Base Cost: "+calc.calculateShippingCost(weight, dist));
		
		if(packagePriority) {
			System.out.println("Priority Surcharge: " + calc.priorityRate);
			if(ptype.equals("express")) {
				//System.out.println("Express package charge with high priority ----> "+calc.calculateShippingCost(weight, dist, packagePriority, ptype));
				System.out.println("Express Package Charge: "+calc.expressCharge);
			}
			else if(ptype.equals("international")) {
				//System.out.println("International package charge with high priority ----> "+calc.calculateShippingCost(weight, dist, packagePriority, ptype));
				System.out.println("Express Package Charge: "+calc.internationalCharge);
			}
			else {
				System.out.println("Standard package charge with high priority: "+calc.calculateShippingCost(weight, dist, packagePriority, ptype));

			}
			
			
		}
		System.out.println("Total Shipping Cost: " +totCost+" rupees");
        System.out.println("Standard Delivery Time: " + pack.getDeliveryTime() + " days");
        
        scan.close();
		
		
		
		
		

		
		

	}

}
