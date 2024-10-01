package Hotel_Reservation_System;

import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        HotelManager manager = new HotelManager();
        
        System.out.println("Welcome to Hotel Reservation System");
        System.out.println(" ");
        System.out.println("1. Add room");
        System.out.println("2. Book room");
        System.out.println("3. Cancel booking");
        System.out.println("4. View available rooms");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
        System.out.println(" ");
        
        Scanner scan = new Scanner(System.in);
        
        while(true) {
        	
        	int choicePick ;
        	System.out.println("Enter choice: ");
        	choicePick= scan.nextInt();
        	scan.nextLine();
        	
        	
        	if(choicePick ==1) {
        		//add
        		int rid;
        		String roomType;
        		double pricePerNight;
        		
        		System.out.println("Enter room id: ");
        		rid = scan.nextInt();
        		scan.nextLine();
        		System.out.println("Enter room type(single/double): ");
        		roomType = scan.nextLine();
   
        		System.out.println("Price per night: ");
        		pricePerNight = scan.nextDouble();
        		scan.nextLine();
        		
        		Room neewRoom = new Room(rid,roomType,pricePerNight );
        		Thread addRoomThread = new Thread(new addRoomThread(manager,neewRoom ));
        		addRoomThread.start();
        		addRoomThread.join();

        	}
        	else if(choicePick==2) {
        		//book
        		int rid;
        		System.out.println("Enter room id: ");
        		rid = scan.nextInt();
        		scan.nextLine();
        		
        		Thread bookRoomThread = new Thread(new bookRoomThread(manager,rid));
        		
        		bookRoomThread.start();
        		bookRoomThread.join();
	
        	}
        	else if(choicePick ==3) {
        		
        		//cancel
        		int rid;
        		System.out.println("Enter room id: ");
        		rid = scan.nextInt();
        		scan.nextLine();
        		Thread cancelRoomThread = new Thread( new cancelRoomThread(manager,rid));
        		cancelRoomThread.start();
        		cancelRoomThread.join();
        	
        	}
        	else if(choicePick ==4) {
        		//view
        		
        		Thread viewAvailableRoomsThread = new Thread( new viewAvailableRoomThread(manager));
        		viewAvailableRoomsThread.start();
        		viewAvailableRoomsThread.join();
        		
        		
        	}
        	else if(choicePick==5) {
        		//checkout
        		
        		int rid;
        		int nights;
        		System.out.println("Enter room id: ");
        		rid = scan.nextInt();
        		scan.nextLine();
        		System.out.println("Enter number of nights: ");
        		nights = scan.nextInt();
        		scan.nextLine();
        		
        		Thread checkOutThread = new Thread(new checkOutRoomThread(manager,rid,nights));
        		checkOutThread.start();
        		checkOutThread.join();

        	}
        	else if(choicePick==6) {
        		System.exit(0);
        	}
        }

	}

}
