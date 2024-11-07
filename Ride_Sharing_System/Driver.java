package Ride_Sharing_System;

public class Driver {
	private int driverId;
	private String name;
	private boolean isAvailable;
	private Ride currentRide;
	
	public Driver(int driverId, String name) {
		this.driverId = driverId;
		this.name = name;
		this.isAvailable = true;
		
		
	}
	
	
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Ride getCurrentRide() {
		return currentRide;
	}
	public void setCurrentRide(Ride currentRide) {
		this.currentRide = currentRide;
	}
	

}
