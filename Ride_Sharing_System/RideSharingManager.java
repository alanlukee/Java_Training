package Ride_Sharing_System;

import java.util.HashMap;
import java.util.Map;

public class RideSharingManager {
	
	private HashMap <Integer, Driver> driverList = new HashMap<Integer, Driver>();
	private HashMap <Integer, Ride> rideList = new HashMap<Integer, Ride>();
	
	
	
	
	public RideSharingManager() {
		Driver driver1 = new Driver(101, "Peter");
		Driver driver2 = new Driver(102, "Sam");
		Driver driver3 = new Driver(103, "Steve");
		Driver driver4 = new Driver(104, "Tony");
		Driver driver5 = new Driver(105, "Barnes");

		driverList.put(driver1.getDriverId(), driver1);
		driverList.put(driver2.getDriverId(), driver2);
		driverList.put(driver3.getDriverId(), driver3);
		driverList.put(driver4.getDriverId(), driver4);
		driverList.put(driver5.getDriverId(), driver5);

		
	}
	
	//request ride
	//accept ride
	//cancel ride.
	
	
	public void requestRide(int rideId, String passengerName, String pickUp, String dropLocation) throws NoDriverAvailableException {
		boolean foundAvailableDriver = false;
		if(driverList.isEmpty()) {
			throw new NoDriverAvailableException("No drivers available");
		}
		else {
			for(Driver driver: driverList.values() ) {
				if(driver.isAvailable()==true) {
					foundAvailableDriver = true;
					Ride ride = new Ride(rideId, passengerName,driver.getName(),pickUp,dropLocation);
					rideList.put(rideId, ride);
					driver.setAvailable(false);
					driver.setCurrentRide(ride);
					ride.setDriverName(driver.getName());
					ride.setStatus("Accepted");
					
					
					
				}
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	public void viewActiveRides() {
		for(Map.Entry<Integer, Ride> entry: rideList.entrySet()) {
			Integer key = entry.getKey();
			Ride ride = entry.getValue();
			if(ride.getStatus().equalsIgnoreCase("In Progress")) {
				System.out.println(ride.toString());
			}
		}
	}

	

}
