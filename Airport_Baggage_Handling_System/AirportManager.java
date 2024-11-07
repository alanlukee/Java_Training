package Airport_Baggage_Handling_System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirportManager {
	
	private HashMap<Integer, Bag> bagList = new HashMap<Integer, Bag>(); //contains only checkedin bags
	private HashMap<Integer, Flight> flightList = new HashMap<Integer, Flight>();
	
	public AirportManager() {
		
		Flight indigo = new Flight(101, "BLR", "8:40");
		Flight vistara = new Flight(102, "JFK", "1:40");
		Flight airindia = new Flight(103, "LHR", "12:40");
		Flight flyemirates = new Flight(104, "TVM","15:20");
		Flight jetblue = new Flight(105, "DUB", "14:35");
		
		flightList.put(indigo.getFlightId(), indigo);
		flightList.put(vistara.getFlightId(), vistara);
		flightList.put(airindia.getFlightId(), airindia);
		flightList.put(flyemirates.getFlightId(), flyemirates);
		flightList.put(jetblue.getFlightId(), jetblue);
		
	}
	
	
	//view loaded bag
	
	
	public void checkInBag(Bag bag) throws BagAlreadyCheckedInException {
		if(bagList.containsKey(bag.getBagId())) {
			throw new BagAlreadyCheckedInException("Bag is already checked in!");
		}
		else {
			bagList.put(bag.getBagId(), bag);
			bag.setStatus("checkedin");
			System.out.println("Bag with bag id: "+bag.getBagId()+" is checked in.");
			System.out.println("Bag details:\n");
			System.out.println(bag.toString());
			System.out.println(" ");
		}
	}
	
	public void loadBagInFlight(int flightId, int bagId) throws UnableToLoadBagException, FlightNotFoundException {
		Bag bag = bagList.get(bagId);
		Flight flight = flightList.get(flightId);
		
		
		if(!(bag.getStatus().equals("checkedin")) || bag==null) {
			throw new UnableToLoadBagException("Bag is null/ bag is not checkedin");
		}
		
		if(flight ==null) {
			throw new FlightNotFoundException("Cant find flight");
		}
		
		try {
			flight.addBag(bag);
		} catch (FlightBagWeightExceeded e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (UnableToLoadBagException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		bag.setStatus("loaded");
		System.out.println("Bag has been loaded to flight");

	}
	
	public void retrieveBag(int bagId) throws BagNotRetrievableException{
		//allow a passenger to retrieve a checked in bag.
		//if bag is not checked , or already loaded in flight , throw bagnotretreievable exception
		
		Bag bag = bagList.get(bagId);
		
		if( bag ==null || !(bag.getStatus().equals("checkedin"))  ) {
			throw new BagNotRetrievableException("Bag is not retrievable");
			
		}
		
		bagList.remove(bag);
		bag.setStatus("retrieved");
		System.out.println("Bag removed.");
		
	
	}
	
	
	
	public void viewFlights() {
		for(Map.Entry<Integer, Flight> entry : flightList.entrySet()) {
			Integer key = entry.getKey();
			Flight flight = entry.getValue();
			System.out.println(flight.toString());
			
		}
	
	}
	
	public void viewLoadedBags(int flightId) {
		Flight flight = flightList.get(flightId);
		
		 if (flight != null) {
			 
			 List<Bag> bList = new ArrayList<Bag>();
			 

			 
			 bList = flight.getBagList();
			 
			 if(bList.isEmpty()) {
				 System.out.println("No bags found");
			 }
			 else {
				 System.out.println("Bags present in flight "+flight.getFlightId()+" is:\n");
				 for(Bag i : bList) {
					 System.out.println(i);
				 }  
			 }
			
	        } else {
	            System.out.println("Flight not found.");
	        }
		
	}
	


	
	
	
	
	public HashMap<Integer, Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(HashMap<Integer, Flight> flightList) {
		this.flightList = flightList;
	}

	

}
