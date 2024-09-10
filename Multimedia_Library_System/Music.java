package Multimedia_Library_System;

public class Music extends MediaContent {
	
	int music_rent_per_day = 13;
	
	public int calculateRentalCost(int days) {
		
		return music_rent_per_day*days;
		
	}

}