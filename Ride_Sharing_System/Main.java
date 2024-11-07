package Ride_Sharing_System;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Ride_Sharing_System");
		System.out.println(" ");
		System.out.println("1. Request a ride");
		System.out.println("2. Accept ride");
		System.out.println("3. Pick up passenger");
		System.out.println("4. Drop passenger");
		System.out.println("5. Cancel ride");
		System.out.println("6. View active rides");
		System.out.println("7. Exit");
		System.out.println(" ");
		
		
		RideSharingManager rsm = new RideSharingManager();
		
		Scanner scan = new Scanner(System.in);
		
		boolean choiceFlag =true;
		int choicePick = 0;
		while(choiceFlag ==true) {
			
			int rideId;
			String pName;
			String pickUp;
			String dropLoc;
			int driverId;
			
			
			
			boolean validationFlag = true;
			while(validationFlag) {
				System.out.println("Enter your choice: ");
				choicePick = scan.nextInt();
				if(choicePick >=1 && choicePick<=7) {
					validationFlag = false;
				}
				else {
					System.out.println("Please enter 1/2/3/4/5/6/7");
				}
			}
			
			if(choicePick ==1) {
				//request ride
				
				System.out.println("Enter ride id: ");
				rideId = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter passenger name: ");
				pName = scan.nextLine();
				System.out.println("Enter pick up location: ");
				pickUp = scan.nextLine();
				System.out.println("Enter drop location: ");
				dropLoc = scan.nextLine();
				
				//Ride ride = new Ride(rideId, pName, pickUp, dropLoc);
				Thread t1 = new Thread(()->{
					try {
						rsm.requestRide(rideId, pName, pickUp, dropLoc);
					} catch (NoDriverAvailableException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				});
				t1.start();
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

			}
			else if(choicePick ==2) {
				//accept ride
				System.out.println("Enter ride id: ");
				rideId = scan.nextInt();
				scan.nextLine();
				
				Thread t2 = new Thread(()->{
					
					try {
						rsm.acceptRide(rideId);
					} catch (RideNotAvailableException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					} catch (NoDriverAvailableException e) {
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
				//pick up
				
				System.out.println("Enter driver id: ");
				driverId = scan.nextInt();
				scan.nextLine();
				
				Thread t3 = new Thread(()->{
					try {
						rsm.pickPassenger(driverId);
					} catch (RideNotAvailableException e) {
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
			else if(choicePick==4) {
				//drop
				
				System.out.println("Enter driver id: ");
				driverId = scan.nextInt();
				scan.nextLine();
				
				Thread t4 = new Thread(()->{
					try {
						rsm.dropPassenger(driverId);
					} catch (RideNotAvailableException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				});
				t4.start();
				try {
					t4.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
			}
			else if(choicePick ==5) {
				//cancel ride
				System.out.println("Enter ride id: ");
				rideId = scan.nextInt();
				scan.nextLine();
				Thread t5 = new Thread(()->{
					try {
						rsm.cancelRide(rideId);
					} catch (RideNotCancelableException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				});
				t5.start();
				try {
					t5.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			else if(choicePick ==6) {
				//view active rides
				Thread t6 = new Thread(()->{
					rsm.viewActiveRides();
				});
				t6.start();
				try {
					t6.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
			}
			else if(choicePick ==7) {
				
				System.exit(0);
			}
			
			else {
				System.out.println("Invalid choice");
			}
		

	}
	}

}
