package Ticket_Booking_System;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Ticket Booking System");
		System.out.println(" ");
		System.out.println("1. Add an event");
		System.out.println("2. Book a ticket");
		System.out.println("3. Cancel Booking");
		System.out.println("4. View Event Availability");
		System.out.println("5. Exit");
		
		EventManager em = new EventManager();
		Scanner scan = new Scanner(System.in);
		
		boolean choiceFlag = true;
		int choicePick = 0;
		
		while(choiceFlag ==true) {
			int eventId;
			int bookId;
			String name;
			int totSeats;
			double price;
			int count;
			
			
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
				//add event
				
				System.out.println("Add event id: ");
				eventId = scan.nextInt();
				scan.nextLine();
				System.out.println("Add event name: ");
				name = scan.nextLine();
				System.out.println("Add total seats for event: ");
				totSeats = scan.nextInt();
				scan.nextLine();
				System.out.println("Add price per ticket");
				price = scan.nextDouble();
				scan.nextLine();
				
				Event event = new Event(eventId, name, totSeats, price);
				
				Thread t1 = new Thread(()->{
					try {
						em.addEvent(event);
					} catch (EventAlreadyExistsException e) {
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
				//book a ticket
				
				System.out.println("Enter booking id: ");
				bookId = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter username: ");
				name = scan.nextLine();
				System.out.println("Enter event id: ");
				eventId = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter number of tickets: ");
				count = scan.nextInt();
				scan.nextLine();
				
				Booking book = new Booking(bookId, name, eventId, count);
				
				Thread  t2 = new Thread(()->{
					try {
						em.bookTicket(book);
					} catch (SeatsNotAvailableException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					} catch (BookingNotCancelableException e) {
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
				//cancel booking
				
				System.out.println("Enter booking id: ");
				bookId = scan.nextInt();
				scan.nextLine();
				
				Thread t3 = new Thread(()->{
					try {
						em.cancelTicket(bookId);
					} catch (BookingNotCancelableException e) {
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
				//view event availability
				Thread t4 = new Thread(()->{
					em.viewEventAvailability();
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
				System.out.println("Thank you for booking. Please visit again");
				System.out.println("Exiting...");
				System.out.println(".......................");
				System.exit(0);
			}
			else {
				System.out.println("Invalid choice");
			}

	}
	}

}
