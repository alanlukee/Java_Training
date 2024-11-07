package Airport_Baggage_Handling_System;

import java.util.ArrayList;
import java.util.List;

public class Flight {
	private int flightId;
	private String destination;
	private String departueTime;
	
	
	private List<Bag> loadedBagsInFlight = new ArrayList<Bag>();
	private double flightBagWeightLimit = 60;
	private double currentFlightBagWeight = 0;

	
	
	
	public Flight(int flightId, String destination, String departureTime) {
		this.flightId = flightId;
		this.destination = destination;
		this.departueTime = departureTime;
	}
	
	public void addBag(Bag bag) throws  FlightBagWeightExceeded, UnableToLoadBagException {
		
		boolean sameBagFound = false;
		
		for(Bag i : loadedBagsInFlight) {
			if(i.getBagId()==bag.getBagId()) {
				sameBagFound = true;
				throw new UnableToLoadBagException("Same bag already loaded in flight");
			}
		}
		if(sameBagFound ==false) {
			
			currentFlightBagWeight = currentFlightBagWeight +bag.getWeight();
			
			if(currentFlightBagWeight>flightBagWeightLimit) {
				throw new UnableToLoadBagException("Flight bag weight exceeded");
			}
			else {
				loadedBagsInFlight.add(bag);
				bag.setStatus("loaded");
				//System.out.println("Bag has been loaded in flight");
			}
			
		}
		
	}
	
	public void removeBag(Bag bag) throws BagNotRetrievableException {
		
		boolean bagFoundToRemove = false;
		
		if(loadedBagsInFlight.isEmpty()) {
			throw new BagNotRetrievableException("Bags not found in flight.");
		}
		
		else {
			
			for(Bag i : loadedBagsInFlight) {
				if(i.getBagId()==bag.getBagId()) {
					bagFoundToRemove = true;
					loadedBagsInFlight.remove(i);
					bag.setStatus("retrieved");
					System.out.println("Bag successfuly retrieved from flight");
				}
			}
			
			if(bagFoundToRemove == false) {
				throw new BagNotRetrievableException("Cant find bag to retrieve!");
			}
		}
		
	}
	
	public String toString() {
		return("Flight ID: "+flightId+"\nDestination: "+destination+ "\nDeparture Time: "+departueTime);
	}
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepartueTime() {
		return departueTime;
	}
	public void setDepartueTime(String departueTime) {
		this.departueTime = departueTime;
	}
	public List<Bag> getBagList() {
		return loadedBagsInFlight;
	}
	public void setBagList(List<Bag> bagList) {
		this.loadedBagsInFlight = bagList;
	}


}
