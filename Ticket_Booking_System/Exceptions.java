package Ticket_Booking_System;


class EventAlreadyExistsException extends Exception{
	EventAlreadyExistsException(String s){
		super(s);
	}
}

class SeatsNotAvailableException extends Exception{
	SeatsNotAvailableException(String s){
		super(s);
	}
}

class BookingNotCancelableException extends Exception{
	BookingNotCancelableException(String s){
		super(s);
	}
}