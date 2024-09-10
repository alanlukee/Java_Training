package Multimedia_Library_System;

public class MediaContent {
	
	int rent_per_day = 15;
	
	public int calculateRentalCost(int days) {
		
		return rent_per_day*days;
		
	}

}
