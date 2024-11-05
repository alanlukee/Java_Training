package Parking_Lot_Management_System;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SpotUnsuitableException, SpotAlreadyOccupiedException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Welcome to Parking Lot Management System");
		System.out.println(" ");
		
		System.out.println("Choose :");
		System.out.println("1. Add parking spot");
		System.out.println("2. Park Vehicle");
		System.out.println("3. Remove vehicle");
		System.out.println("4. View Available Spots");
		System.out.println("5. Calculate parking fee");
		System.out.println(" ");
		
		ParkingLotManager plm = new ParkingLotManager();
		
		Scanner scan = new Scanner(System.in);
		boolean choiceFlag = true;
		int choicePick = 0;
		
		while(choiceFlag) {
			
			int spotId;
			String license;
			String vehicleType;
			String spotType;
			boolean avail;
			double pricePerHour;
			int hours;
			
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
			
			if(choicePick==1) {
				//add parking spot
				
				System.out.println("Add spot id: ");
				spotId = scan.nextInt();
				scan.nextLine();
				System.out.println("Add spot type(compact, regular, large): ");
				spotType = scan.nextLine();
				System.out.println("spot Occupied?(true,false): ");
				avail = scan.nextBoolean();
				System.out.println("Add price rate per hour:");
				pricePerHour = scan.nextDouble();
				scan.nextLine();
				
				ParkingSpot newSpot = new ParkingSpot(spotId, spotType, avail, pricePerHour);
				
				Thread t1 = new Thread(()->{
					try {
						plm.addParkingSpot(newSpot);
						
					} catch (SpotAlreadyExistsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
			else if(choicePick==2) {
				//park vehicle
				
				System.out.println("Add spot id to park: ");
				spotId = scan.nextInt();
				scan.nextLine();
				System.out.println("Add license plate number");
				license = scan.nextLine();
				System.out.println("Add vehicle type (motorcycle,car,truck)");
				vehicleType = scan.nextLine();
				
				Vehicle newVehicle = new Vehicle(license, vehicleType);
				
				Thread t2 = new Thread(() -> {
					try {
						plm.parkVehicle(spotId, newVehicle);
					} catch (SpotUnsuitableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SpotAlreadyOccupiedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				
				t2.start();
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
			else if(choicePick ==3) {
				//remove vehicle
				
				System.out.println("Add spot id: ");
				spotId = scan.nextInt();
				scan.nextLine();
				
				
				Thread t3 = new Thread(() ->{
					try {
						plm.removeVehicle(spotId);
					} catch (SpotNotOccupiedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				});
				t3.start();
				try {
					t3.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			else if(choicePick ==4) {
				//view available spots
				
				Thread t4 = new Thread(() ->{
					try {
						plm.viewAvailableSpots();
					} catch (SpotUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				
				t4.start();
				try {
					t4.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}
			else if(choicePick ==5 ) {
				//calc feee
				System.out.println("Add spot id: ");
				spotId = scan.nextInt();
				scan.nextLine();
				System.out.println("Add hours parked: ");
				hours = scan.nextInt();
				
				plm.calculateParkingFee(spotId, hours);
			}
			else {
				System.out.println("Invalid input");
			}
			
			}

			
		}
		
		
		

	}


