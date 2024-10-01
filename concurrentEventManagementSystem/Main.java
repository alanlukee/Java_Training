package com.concurrentEventManagementSystem;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("Concurrent Event Management System.");
		System.out.println(" ");
		System.out.println("1. Add Event.");
		System.out.println("2. Mark event as COMPLETE");
		System.out.println("3. Display events.");
		System.out.println("4. Exit");
		EventManager eventManager = new EventManager();

		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int eID;
			String name;
			int choicePick ;
			System.out.println("Enter choice.");
			choicePick = scan.nextInt();
			scan.nextLine();
			
			
			if(choicePick ==1) {
				//adding event.
				System.out.println("Enter event ID:");
				eID = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter event name: ");
				name = scan.nextLine();
				Event event = new Event(eID, name);
				Thread addThread = new Thread(new addingEventThread(eventManager, event));
                addThread.start();
                addThread.join();
                
             
	
			}
			
			
			else if(choicePick ==2) {
				//mark as complete
				
                System.out.println("Enter event ID to mark as complete: ");
                int id = scan.nextInt();
                scan.nextLine();
                Event eventMarker = new Event(id, " ");
                Thread markAsCompleteThread = new Thread(new markEventCompleteThread(eventManager, eventMarker));
                markAsCompleteThread.start();
                markAsCompleteThread.join();
                
			}

			else if(choicePick ==3) {
				//display events
				eventManager.displayEvents();
			}

			else if(choicePick ==4) {
				System.exit(0);
			}
		}

	}

}
