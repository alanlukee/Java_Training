package Ride_Sharing_System;

import java.util.Objects;

public class Ride {
	private int rideId;
	private String passengerName;
	private String driverName;
	private String pickUpLocation;
	private String dropLocation;
	private String status;
	
	
	public Ride(int rideId, String passengerName, String driverName, String pickUpLocation, String dropLocation) {
		
		
		this.rideId = rideId;
		this.passengerName = passengerName;
		this.driverName = driverName;
		this.pickUpLocation =pickUpLocation;
		this.dropLocation = dropLocation;
		this.status = "Requested";
	}
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(rideId);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ride other = (Ride) obj;
		return rideId == other.rideId;
	}


	@Override
	public String toString() {
		return "Ride [rideId=" + rideId + ", passengerName=" + passengerName + ", driverName=" + driverName
				+ ", pickUpLocation=" + pickUpLocation + ", dropLocation=" + dropLocation + ", status=" + status + "]";
	}







	public int getRideId() {
		return rideId;
	}
	public void setRideId(int rideId) {
		this.rideId = rideId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getPickUpLocation() {
		return pickUpLocation;
	}
	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
