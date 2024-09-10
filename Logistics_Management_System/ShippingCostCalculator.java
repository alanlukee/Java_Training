package Logistics_Management_System;

public class ShippingCostCalculator {
	
	double ratePerKg = 30;
	double ratePerKm = 0.5;
	double priorityRate = 100;
	double expressCharge = 50;
	double internationalCharge = 100;
	
	public double calculateShippingCost(double weight, double distance) {
		
		return ((ratePerKg*weight)+(distance*ratePerKm));
	}
	public double calculateShippingCost(double weight, double distance, boolean priority) {
		if (priority==true) {
	
		return ((ratePerKg*weight)+(distance*ratePerKm)) +priorityRate ;
	}
		return ((ratePerKg*weight)+(distance*ratePerKm)) ;
	}
	
	public double calculateShippingCost(double weight, double distance, boolean priority, String packageType) {
		double cost = 0;
		if(priority==true) {
			if(packageType.equals("express")) {
				cost=((ratePerKg*weight)+(distance*ratePerKm) +priorityRate +expressCharge);
			}
			else if(packageType.equals("international")) {
				cost= ((ratePerKg*weight)+(distance*ratePerKm) +priorityRate +internationalCharge);
			}
			else {
				cost=((ratePerKg*weight)+(distance*ratePerKm) +priorityRate);
			}
		}
		return cost;
	}
	
}
