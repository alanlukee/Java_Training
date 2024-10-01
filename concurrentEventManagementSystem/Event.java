package com.concurrentEventManagementSystem;

public class Event {
	
	private int eventID;
	private String name;
	private Status status;
	
	public Event(int eventID,String name) {
		this.setEventID(eventID);
		this.setName(name);
		this.setStatus(Status.UPCOMING);
		
	}
	
	
	public String toString() {
		return("[ EventID: "+eventID+", Name: "+name+", Status: "+status+" ]");
	}
	
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}
		
		if(o instanceof Event) {
			Event e2 = (Event)o;
			
			if(this.eventID==e2.eventID) {
				return true;
			}
			
		}
		return false;
		
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
