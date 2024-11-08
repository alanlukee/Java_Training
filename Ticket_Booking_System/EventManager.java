package Ticket_Booking_System;

import java.util.HashMap;

public class EventManager {
	
	private HashMap<Integer, Event> eventList = new HashMap<Integer, Event>(); 
	private HashMap<Integer, Booking> bookingList = new HashMap<Integer, Booking>();
	
	
	
	//add event
	//book ticket
	//cancel booking
	//view event avail
	
	
	public void addEvent(Event e) throws EventAlreadyExistsException {
		
		boolean foundEvent = false;
		for(Event i : eventList.values()) {
			if(i.getEventId()==e.getEventId()) {
				foundEvent = true;
				throw new EventAlreadyExistsException("Event with id: "+i.getEventId()+" already exists");
			}
		}
		if(foundEvent == false) {
			eventList.put(e.getEventId(), e);
			System.out.println("Event with id: "+e.getEventId()+" added successfully");
			
		}
		
	}
	
	public void bookTicket(Booking book) throws SeatsNotAvailableException, BookingNotCancelableException {
		Event e = eventList.get(book.getEventId());
		
		if(bookingList.containsKey(book.getBookingId())) {
			throw new BookingNotCancelableException("Booking already exists");
		}
		
		if(e==null) {
			throw new SeatsNotAvailableException("Event not found");
		}
		
		if(book.getNumberOfTickets()>e.getTotalSeats()) {
			throw new SeatsNotAvailableException("Requested seats more than total number of seats of the event");
		}
		else {
			if(book.getNumberOfTickets() + e.getBookedSeats() <e.getTotalSeats()) {
				e.setBookedSeats(book.getNumberOfTickets() + e.getBookedSeats());
			}
			else {
				throw new SeatsNotAvailableException("Requested seats more than total number of seats of the event");
			}
	
			if(e.getBookedSeats()==e.getTotalSeats()) {
				System.out.println("Seats for event are now full");
			}
			
			book.setStatus("Confirmed");
			bookingList.put(book.getBookingId(), book);
			System.out.println("Your booking for event: "+e.getEventName()+" has been confirmed");
			System.out.println("Your booking details: ");
			System.out.println(book);
			

			
		}
		
				
	}
	
	public void cancelTicket(int bookingId) throws BookingNotCancelableException {
		Booking book = bookingList.get(bookingId);
		Event e = eventList.get(book.getEventId());
		
		if(!(bookingList.containsKey(book.getBookingId()))) {
			throw new BookingNotCancelableException("Booking doesn not exists");
		}
		
		else {
			if(book.getStatus().equals("Cancelled")) {
				throw new BookingNotCancelableException("This booking has been cancelled already");
			}
			else {
				book.setStatus("Cancelled");
				e.setBookedSeats( e.getBookedSeats() - book.getNumberOfTickets());
				System.out.println("Your booking for the event has been cancelled");
				
			}
		}
		
	}
	
	public void viewEventAvailability() {
		if(eventList.isEmpty()) {
			System.out.println("No events present");
		}
		else {
			for(Event e :eventList.values()) {
				System.out.println("Event name: " +e.getEventName());
				System.out.println("Event Id: "+e.getEventId());
				System.out.println("Event price: "+e.getPricePerTicket());
				System.out.println("Seats occupied: "+e.getBookedSeats()+"/" +e.getTotalSeats());
				System.out.println(" ");
				
			}
		}

	}
	

	
}


	





