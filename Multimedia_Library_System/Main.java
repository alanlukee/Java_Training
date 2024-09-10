package Multimedia_Library_System;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        MediaLibrary media = new MediaLibrary();
        
        System.out.println("Choose from the following content Id's");
        System.out.println("1. Book");
        System.out.println("2. Music");
        System.out.println("3. Video");
        
        System.out.print("Enter Content ID: ");
        int contentId = scan.nextInt();
        
        System.out.print("Enter User ID: ");
        int userId = scan.nextInt();
        
        System.out.print("Enter Duration (in days): ");
        int duration = scan.nextInt();
        scan.close();
        
        MediaContent content = null;
        if(contentId==1) {
        	content = new Book();
        }
        else if(contentId==2) {
        	content = new Video();
        }
        else if(contentId==3) {
        	content = new Music();
        }
        else {
        	System.out.println("invalid");
        }
        media.displayContentDetails(contentId, userId, duration);
        int rent = content.calculateRentalCost(duration);
        System.out.println("Rental Cost: " + rent+" rupees");
	}

}
