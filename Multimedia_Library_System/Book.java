package Multimedia_Library_System;

public class Book extends MediaContent {
	
	int book_rent_per_day = 12;
	
	public int calculateRentalCost(int days) {
		
		return book_rent_per_day*days;
		
	}

}
