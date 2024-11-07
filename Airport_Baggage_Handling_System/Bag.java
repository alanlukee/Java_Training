package Airport_Baggage_Handling_System;

import java.util.Objects;

public class Bag {
	
	private int bagId;
	private String ownerName;
	private double weight;
	private String destination;
	private String status;
	
	public Bag(int bagId, String ownerName, double weight, String destination, String status) {
		this.bagId = bagId;
		this.ownerName = ownerName;
		this.weight = weight;
		this.destination = destination;
		this.status = status;
	
	}
	
	public String toString() {
		return ("Bag ID: "+bagId+"\nBag Owner: "+ownerName+"\nBag Weight: "
				+ ""+weight+"\nDestination: "+destination+"\nStatus: "+status);
	}
	
	public int hashCode() {
		return(Objects.hash(bagId));
	}
	
	public boolean equals(Object o) {
		if (this ==o) {
			return true;
		}
		if( o instanceof Bag ) {
			Bag s2 = (Bag) o;
			if(bagId==s2.bagId){
				return true;
			}
			else {
				return false;
			}
		}
		return false;

	}

	public int getBagId() {
		return bagId;
	}

	public void setBagId(int bagId) {
		this.bagId = bagId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
