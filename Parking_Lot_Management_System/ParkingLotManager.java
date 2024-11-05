package Parking_Lot_Management_System;

import java.util.ArrayList;

public class ParkingLotManager {
	
	 ArrayList<ParkingSpot> parkingspots = new ArrayList<ParkingSpot>();
	
	public ParkingLotManager() {
		
		ParkingSpot sp1 = new ParkingSpot(1, "compact", false, 10);
		ParkingSpot sp2 = new ParkingSpot(2, "regular", false, 20);
		ParkingSpot sp3 = new ParkingSpot(3, "compact", false, 10);
		ParkingSpot sp4 = new ParkingSpot(4, "large", false, 30);
		ParkingSpot sp5 = new ParkingSpot(5, "regular", false, 20);
		
		parkingspots.add(sp1);
		parkingspots.add(sp2);
		parkingspots.add(sp3);
		parkingspots.add(sp4);
		parkingspots.add(sp5);

		
		
	}


	public void addParkingSpot(ParkingSpot spot) throws SpotAlreadyExistsException {
		
		boolean spotOccupied = false;
		
		for(ParkingSpot i : parkingspots) {
			if(i.getSpotId()==spot.getSpotId()) {
				spotOccupied = true;
				throw new SpotAlreadyExistsException("Spot already exists");
			}
			
		}
		
		if(spotOccupied ==false) {
			parkingspots.add(spot);
		}
		
	}
	
	public void parkVehicle(int spotId, Vehicle vehicle) throws SpotUnsuitableException, SpotAlreadyOccupiedException {
		
		boolean spotOccupied = false;
		for(ParkingSpot i : parkingspots) {
			if(i.getSpotId()==spotId) {
				if(i.isOccupied()==false) {
					spotOccupied =false;
					if(vehicle.getVehicleType().equals("motorcycle") && i.getSpotType().equals("compact")) {
						System.out.println("Motorcycle can be parked");
						i.setOccupied(true);
						break;
					}
					else if(vehicle.getVehicleType().equals("car") && i.getSpotType().equals("regular")) {
						System.out.println("Car can be parked");
						i.setOccupied(true);
						break;

					}
					else if(vehicle.getVehicleType().equals("truck") && i.getSpotType().equals("large")) {
						System.out.println("Truck can be parked");
						i.setOccupied(true);
						break;
					}
					else {
						throw new SpotUnsuitableException("Spot unsuitable for parking");
					}

				}
				else {
					spotOccupied = true;
					break;
				}
			}
		}
		
		if(spotOccupied ==true) {
			throw new SpotAlreadyOccupiedException("Spot already occupied");
		}	
	}
	
	
	public void removeVehicle(int spotId) throws SpotNotOccupiedException {
		boolean foundVehicle = false;
		for(ParkingSpot i : parkingspots) {
			
			if(i.getSpotId() == spotId) {
				foundVehicle = true;
				System.out.println("Vehicle removed");
				i.setOccupied(false);
				break;
			}
		}
		if(foundVehicle = false) {
			throw new SpotNotOccupiedException("Spot is not occupied");
		}
		
	}
	
	public void viewAvailableSpots() throws SpotUnavailableException {
		

		
		for(ParkingSpot i : parkingspots) {
			if(i.isOccupied() == false) {
				System.out.println(" ");
				System.out.println(i.getSpotId()+ " is available\n");
				System.out.println(i.toString());
				System.out.println(" ");
			}
			else {
				System.out.println(" ");
				System.out.println(i.getSpotId()+ " is not available\n");
			}
			
		}

	}
	
	public void calculateParkingFee(int spotId, int hours ) {
		
		double parkingFee= 0;
		
		for(ParkingSpot i : parkingspots) {
			
			if(i.getSpotId()==spotId) {
				parkingFee = i.getPricePerHour() *hours;
				break;
			}

		}
		System.out.println("Parking cost for vehicle in spot-id: "+spotId+" is "+parkingFee+" rupees");
		
	}

}
