package Ticket_Booking_System;

import java.util.Objects;

public class Event {
	
	private int eventId;
	private String eventName;
	private int totalSeats;
	private int bookedSeats;
	private double pricePerTicket;
	
	
	public Event(int eventId, String eventName, int totalSeats, double pricePerTicket) {
		
		this.eventId = eventId;
		this.eventName = eventName;
		this.totalSeats = totalSeats;
		this.pricePerTicket = pricePerTicket;
		this.bookedSeats = 0;
	}
	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(eventId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return eventId == other.eventId;
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", totalSeats=" + totalSeats
				+ ", bookedSeats=" + bookedSeats + ", pricePerTicket=" + pricePerTicket + "]";
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	public double getPricePerTicket() {
		return pricePerTicket;
	}
	public void setPricePerTicket(double pricePerTicket) {
		this.pricePerTicket = pricePerTicket;
	}
	
	public int getAvailableSeats() {
		return this.totalSeats;
	
	}
	
	
	

}
