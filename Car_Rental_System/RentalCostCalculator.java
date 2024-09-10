package Car_Rental_System;

import java.util.List;

public class RentalCostCalculator {
	
	public double calculateRentalCost(String carType, int rentalDuration) {
		
		Car cartype;
		double car_rate = 0;
		
		if(carType.toLowerCase().equals("economy")) {
			
			cartype = new EconomyCar();
			car_rate = cartype.getBaseRatePerDay();			
		}
		else if (carType.toLowerCase().equals("midsize")) {
			
			cartype = new MidsizeCar();
			car_rate = cartype.getBaseRatePerDay();	
			
		}
		else if(carType.toLowerCase().equals("luxury")) {
			
			cartype = new LuxuryCar();
			car_rate = cartype.getBaseRatePerDay();
			
		}
		else {
			
			System.out.println("invalid car type");
		}
		
		return (car_rate * rentalDuration) ;
		 
	}
	
	public double calculateRentalCost(String carType, int rentalDuration, boolean isInsuranceIncluded) {
		
		double base_rate = calculateRentalCost(carType, rentalDuration);
		
        if (isInsuranceIncluded) {
        	
            base_rate += 500;  
        }
        return base_rate;
		
	}
	public double calculateRentalCost(String carType, int rentalDuration, boolean isInsuranceIncluded, List<String> additionalFeatures) {
		
		double base_rate = calculateRentalCost(carType,rentalDuration,isInsuranceIncluded);
		
		for( String adf: additionalFeatures) {
			if (adf.toLowerCase().equals("rear view camera")){
				base_rate +=400;
				
			}
			else if (adf.toLowerCase().equals("heated seats")){
				base_rate+= 500;
				
			}
			else if(adf.toLowerCase().equals("gps")){
				base_rate += 100;
			}
		}
		return base_rate;
	}
}
