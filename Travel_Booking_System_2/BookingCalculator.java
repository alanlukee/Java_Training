package Travel_Booking_System_2;

//import java.util.ArrayList;
import java.util.List;

public class BookingCalculator {
	
	public double calculateTotalCost(List<Booking> bookList) {
		double totalCost = 0;
		
		for(Booking book : bookList) {
			totalCost = totalCost + book.getCost();
		}
		
		return totalCost;
		
	}
	public double calculateTotalCost(List<Booking> bookList, String discountCode ) {
		
		double totalCost = 0;
		
		for(Booking book : bookList) {
			totalCost = totalCost + book.getCost();
		}
		
		if(discountCode.equals("JAVA2024")) {   //20% off
			totalCost = totalCost - (0.2*totalCost);
		}
		
		return totalCost;
		
	}
	public double calculateTotalCost(List<Booking> bookList, String discountCode, double taxRate) {
		
		double totalCost = 0;
		
		for(Booking book : bookList) {
			totalCost = totalCost + book.getCost();
		}
		
		if(discountCode.equals("JAVA2024")) {   //20% off
			totalCost = totalCost - (0.2*totalCost);
		}
		
		totalCost = totalCost +((taxRate/100)*totalCost);
		return totalCost;
		
	}
		
	}
	


