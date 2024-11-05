package Parking_Lot_Management_System;

import java.util.Objects;

public class ParkingSpot {
	
	private int spotId;
	private String spotType;

	private boolean isOccupied;
	private double pricePerHour;
	
	public ParkingSpot(int spotId, String spotType, boolean isOccupied, double pricePerHour) {
		this.spotId = spotId;
		this.spotType = spotType;
		this.isOccupied = isOccupied;
		this.pricePerHour = pricePerHour;
		
	}
	
	public String toString() {
		return ("Spot ID: "+spotId + "Spot Type: "+spotType+ "is Occupied? :"+isOccupied+ " Price per Hour: "+pricePerHour);
		
	}
	
	public int hashCode() {
		return  Objects.hash(spotId);
	}
	
	public boolean equals(Object o) {
		if (this ==o) {
			return true;
		}
		if( o instanceof ParkingSpot ) {
			ParkingSpot s2 = (ParkingSpot) o;
			if(spotId==s2.spotId){
				return true;
			}
			else {
				return false;
			}
		}
		return false;

	}
	
	
	public int getSpotId() {
		return spotId;
	}

	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}

	public String getSpotType() {
		return spotType;
	}

	public void setSpotType(String spotType) {
		this.spotType = spotType;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}


}
