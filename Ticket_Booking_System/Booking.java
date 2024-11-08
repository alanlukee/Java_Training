package Ticket_Booking_System;

public class Booking {
	private int bookingId;
	private String userName;
	private int eventId;
	private int numberOfTickets;
	private String status;
	
	public Booking(int bookingId, String userName, int eventId, int numberofTickets) {
		this.bookingId = bookingId;
		this.userName = userName;
		this.eventId = eventId;
		this.numberOfTickets = numberofTickets;
		this.status = "null";
	}
	
	

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userName=" + userName + ", eventId=" + eventId
				+ ", numberOfTickets=" + numberOfTickets + ", status=" + status + "]";
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	

}
