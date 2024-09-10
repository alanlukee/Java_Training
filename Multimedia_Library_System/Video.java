package Multimedia_Library_System;

public class Video extends MediaContent {
	
	int video_rent_per_day = 14;
	
	public int calculateRentalCost(int days) {
		
		return video_rent_per_day*days;
		
	}

}
