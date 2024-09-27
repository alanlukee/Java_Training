package Airline_Reservation_System;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReservationSystem {
    private List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Flight findFlight(String flightNumber) throws FlightNotFoundException {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        throw new FlightNotFoundException("Flight " + flightNumber + " not found.");
    }

    public void bookFlight(String flightNumber) {
        try {
            Flight flight = findFlight(flightNumber);
            flight.bookSeat();
            System.out.println("Flight booked successfully.");
        } catch (FlightNotFoundException | FlightFullException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelFlight(String flightNumber) {
        try {
            Flight flight = findFlight(flightNumber);
            flight.cancelSeat();
            System.out.println("Flight canceled successfully.");
        } catch (FlightNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkAvailability(String flightNumber) {
        try {
            Flight flight = findFlight(flightNumber);
            System.out.println(flight);
        } catch (FlightNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ReservationSystem m1 = new ReservationSystem();
        
        Flight f1 = new Flight("1111", "10:00 AM", "12:00 PM", 20);
        Flight f2 = new Flight("2222", "1:00 PM", "3:00 PM", 30);
        
        m1.addFlight(f1);
        m1.addFlight(f2);
        
        System.out.println("Welcome to the airline reservation system!");
        System.out.println(" ");
        System.out.println("1. Book flight");
        System.out.println("2. Cancel flight");
        System.out.println("3. Check flight availability");
        System.out.println("4. Exit");
        System.out.println(" ");

        try (Scanner scan = new Scanner(System.in)) {
			while (true) {
				String passengerName;
				int choice = 0;
				boolean validationFlag = true;
				
				while(validationFlag) {
					 System.out.print("Enter your choice: ");
					 choice = scan.nextInt();
					 scan.nextLine(); 
					 if(choice>=1 && choice<=4) {
						 validationFlag = false;
						 
					 }
					 else {
						 validationFlag = true;
						 System.out.println("Please enter 1/2/3/4");
					 }
					
				}
			   
			    if (choice == 4) {
			        System.exit(0);
			    }

			    System.out.print("Enter flight number: ");
			    String flightNumber = scan.nextLine();
			    
			    switch (choice) {
			        case 1:
			        	
			        	System.out.println("Enter passenger name: ");
			        	passengerName = scan.nextLine();
			            m1.bookFlight(flightNumber);
			            break;
			        case 2:
			            m1.cancelFlight(flightNumber);
			            break;
			        case 3:
			            m1.checkAvailability(flightNumber);
			            break;
			        default:
			            System.out.println("Invalid choice");
			    }
			}
		}
    }
}
