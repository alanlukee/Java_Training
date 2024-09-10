package Restaurant_Management_System;

//import java.util.ArrayList;
import java.util.List;

public class OrderCalculator {
	
	public double calculateTotalCost(List<MenuItem> orderList) {
		
		double totCost = 0;
		
		for(MenuItem item: orderList) {
			totCost = totCost +(item.getPrice()*item.quantity);
		}
		
		return totCost;
		
	}
	
	public double calculateTotalCost(List<MenuItem> orderList,String discountCode) {
		
		double totCost = 0;
		for(MenuItem item: orderList) {
			totCost = totCost +(item.getPrice()*item.quantity);
		}
		if(discountCode.equals("JAVA2024")) {   //20% off
			totCost = totCost - (0.2*totCost);
		}
		
		return totCost;
		
	}
	public double calculateTotalCost(List<MenuItem> orderList,String discountCode, double taxRate ) {
		
		double totCost = 0;
		for(MenuItem item: orderList) {
			totCost = totCost +(item.getPrice()*item.quantity);
		}
		
		//helo
		
		if(discountCode.equals("JAVA2024")) {   //20% off
			totCost = totCost - (0.2*totCost);
		}
		
		totCost = totCost +((taxRate/100)*totCost);
		
		
		return totCost;
		
	}
	
}
