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
	//pickUpPassenger
	//dropPassenger
	//cancel ride.
	
	
	
	//driver -> true and false
	//ride -> "requested, accepted, in progress, completed, cancelled.
	
	
	public void requestRide(int rideId, String passengerName, String pickUp, String dropLocation) throws NoDriverAvailableException {
		boolean foundAvailableDriver = false;
		if(driverList.isEmpty()) {
			throw new NoDriverAvailableException("No drivers available");
		}
		else {
			for(Driver driver: driverList.values() ) {
				if(driver.isAvailable()==true) {
					foundAvailableDriver = true;
					Ride ride = new Ride(rideId, passengerName,pickUp,dropLocation);
					
					rideList.put(rideId, ride);

					ride.setStatus("Requested");
					
					System.out.println("Ride requested and and concerned driver will pick you up");
					break;
				}
			}
			if(foundAvailableDriver == false) {
				throw new NoDriverAvailableException("No available drivers");
			}
			
		}
		
		
	}
	
	public void acceptRide(int rideId) throws RideNotAvailableException, NoDriverAvailableException {
		
		Ride ride = rideList.get(rideId);
		//Driver driver = driverList.get(driverId);
		
//		if(ride==null | !(ride.getStatus().equals("Requested"))) {
//			throw new RideNotAvailableException("Ride is not available");
//			
//		}
		
		if(ride ==null) {
			throw new RideNotAvailableException("Ride is not available");
		}
		else {
			
		}
		boolean driverSelection = false;
		
		if(driverList.isEmpty()) {
			throw new NoDriverAvailableException("No drivers available");
		}
		else {
			for(Driver driver: driverList.values()) {
				if(driver.isAvailable()==true && driver.getCurrentRide()==null) {
					driverSelection = true;
					ride.setDriverId(driver.getDriverId());
					driver.setAvailable(false);
					//ride.setDriverName(driver.getName());
					ride.setStatus("Accepted");
					driver.setCurrentRide(ride);
				
					System.out.println("Your ride has been accepted by driver named "+driver.getName()+"- "+ driver.getDriverId()+", and will pick you up shortly");
					break;
				}
				
			}
			if(driverSelection ==false) {
				throw new NoDriverAvailableException("Not available drivers found");
			}
			
		}
	}
	
	
	public void cancelRide(int rideId) throws RideNotCancelableException {
		Ride ride = rideList.get(rideId);
		

		
		if(ride==null || ride.getStatus().equals("Completed") ||  ride.getStatus().equals("In Progress")
				||ride.getStatus().equals("Cancelled") ) {
			
			throw new RideNotCancelableException("Ride cannot be cancelled");
		}
		else {
			ride.setStatus("Cancelled");
			Driver driver = driverList.get(ride.getDriverId());
			driver.setAvailable(true);
			driver.setCurrentRide(null);
			System.out.println("Ride has been cancelled");
		}
	}
	
	public void pickPassenger(int driverId) throws RideNotAvailableException {
		
		
		Driver driver = driverList.get(driverId);
		Ride ride = null;
		if (driver != null) {
			ride = driver.getCurrentRide();
		}
		
		if(driver==null || ride==null) {
			throw new RideNotAvailableException("Ride is not available");
		}
		if(!ride.getStatus().equals("Accepted")) {
			throw new RideNotAvailableException("Ride not accepted by driver ");
		}
	
			driver.getCurrentRide().setStatus("In Progress");
			driver.setAvailable(false);
			System.out.println("Driver has picked up "+driver.getCurrentRide().getPassengerName()
					+" from "+driver.getCurrentRide().getPickUpLocation());
	
		
	}
	public void dropPassenger(int driverId) throws RideNotAvailableException {
		
		
		Driver driver = driverList.get(driverId);
		Ride ride = null;
		
		if (driver != null) {
			ride = driver.getCurrentRide();
		}
		if(driver==null || ride==null) {
			throw new RideNotAvailableException("Ride/Driver is not available");
		}
		
		if(ride.getStatus().equals("Requested") || ride.getStatus().equals("Completed")  
				|| ride.getStatus().equals("Accepted") || ride.getStatus().equals("Cancelled")) {
			
			throw new RideNotAvailableException("Ride not in progress");
			
		}
		
		else {
			driver.getCurrentRide().setStatus("Completed");
			driver.setAvailable(false);
			System.out.println("Driver has dropped "+driver.getCurrentRide().getPassengerName()
					+" at "+driver.getCurrentRide().getDropLocation());
			driver.setCurrentRide(null);
			
		}
		
	}
	

	
	public void viewActiveRides() {
		boolean foundActiveRide = false;
		for(Map.Entry<Integer, Ride> entry: rideList.entrySet()) {
			Integer key = entry.getKey();
			Ride ride = entry.getValue();
			if(ride.getStatus().equalsIgnoreCase("In Progress")) {
				foundActiveRide = true;
				System.out.println(ride.toString());
			}
		}
		if(foundActiveRide==false) {
			System.out.println("No active rides currently");
		}
		
	}

	

}
