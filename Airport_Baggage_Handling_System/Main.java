package Airport_Baggage_Handling_System;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Airport Baggage Handling System");
		System.out.println(" ");
		
		System.out.println("1. Check in bag");
		System.out.println("2. Load bag into flight");
		System.out.println("3. Retrieve Bag");
		System.out.println("4. View loaded bags");
		System.out.println("5. Exit");
		System.out.println(" ");
		
		AirportManager am = new AirportManager();
		Scanner scan = new Scanner(System.in);
		
		boolean choiceFlag = true;
		int choicePick = 0;
		
		while(choiceFlag ==true) {
			int bagId;
			String bagOwnerName;
			float weight;
			String destination;
			String status;
			int flightId;
		
			
			
			boolean validationFlag = true;
			while(validationFlag) {
				System.out.println("Enter your choice: ");
				choicePick = scan.nextInt();
				if(choicePick >=1 && choicePick<=5) {
					validationFlag = false;
				}
				else {
					System.out.println("Please enter 1/2/3/4/5");
				}
			}
			
			if(choicePick ==1) {
				//check in bag

				
				System.out.println("Enter bag details:");
				System.out.println("Enter bag id: ");
				bagId = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter bag owner name: ");
				bagOwnerName = scan.nextLine();
				System.out.println("Enter weight: ");
				weight= scan.nextFloat();
				scan.nextLine();
				System.out.println("Enter destination: ");
				destination = scan.nextLine();
				System.out.println("Enter current status(set to null initially)");
				status = scan.nextLine();
				
				Bag bag = new Bag(bagId, bagOwnerName, weight, destination, status);
				
				
				Thread t1 = new Thread(() ->{
					try {
						am.checkInBag(bag);
					} catch (BagAlreadyCheckedInException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				});
				t1.start();
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (choicePick ==2) {
				//load bag into flight
				
				System.out.println("Enter flight id:");
				flightId = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter bag id:");
				bagId = scan.nextInt();
				scan.nextLine();
				
				Thread t2 = new Thread(()->{
					try {
						am.loadBagInFlight(flightId, bagId);
					} catch (UnableToLoadBagException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					} catch (FlightNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				});
				t2.start();
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
			}
			else if(choicePick ==3) {
				//retrieve bag
				System.out.println("Enter bag id:");
				bagId = scan.nextInt();
				scan.nextLine();
				
				Thread t3 = new Thread(()->{
					try {
						am.retrieveBag(bagId);
					} catch (BagNotRetrievableException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				});
				t3.start();
				try {
					t3.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				
			}
			else if(choicePick ==4) {
				//view loaded bags
				System.out.println("Enter flight id: ");
				flightId = scan.nextInt();
				scan.nextLine();
				Thread t4 = new Thread(() ->{
					am.viewLoadedBags(flightId);
				});
				
				t4.start();
				try {
					t4.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
			}
			
			
		}
		
		

	}

}
