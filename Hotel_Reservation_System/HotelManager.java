package Hotel_Reservation_System;

import java.util.ArrayList;
import java.util.List;

public class HotelManager {
	//add room , book room, cancel booking, view rooms, checkout.
	
	List<Room> rooms ;
	
	public HotelManager() {
		this.rooms = new ArrayList<>();
	}
	
	public synchronized void addRoom(Room room) throws RoomAlreadyExistsException {
		boolean foundRoom = false;
		for (Room i : rooms) {
			if(i.getRoomId() ==room.getRoomId()) {
				foundRoom = true;
				throw new RoomAlreadyExistsException("Room already exists.");
			}
		}
		if(foundRoom ==false) {
			rooms.add(room);
			System.out.println("Room added.");
		}
	}
	
	public synchronized void bookRoom(int roomID) throws RoomNotAvailableException {
		Room r = seachRoom(roomID);
		
		if(r==null) {
			throw new RoomNotAvailableException("Room already occupied. Not available.");
		}
		
		if(r.isAvailable()==false) {
			throw new RoomNotAvailableException("Room already occupied. Not available.");
		}
		r.setAvailable(false);
		System.out.println("Room has been booked.");
		
	}
	
	public synchronized void cancelBooking(int roomID) throws RoomNotBookedException, RoomNotAvailableException {
		Room r = seachRoom(roomID);
		
		if(r==null) {
			throw new RoomNotAvailableException("Room already occupied. Not available.");
		}
		
		if(r.isAvailable()==true) {
			throw new RoomNotBookedException("Room is not booked...for you to cancel.");
		}
		
		r.setAvailable(true);
		System.out.println("Booking canceled.");


	}
	
	public synchronized List<Room> viewAvailableRooms(){
		List<Room> availRooms = new ArrayList<>();
		for(Room i : rooms) {
			if(i.isAvailable() ==true) {
				availRooms.add(i);
			}
		}
		return availRooms;

	}
	
	public synchronized double checkout(int roomID, int nights) throws RoomNotBookedException {
		Room r = seachRoom(roomID);
		if (r == null || r.isAvailable()) {
            throw new RoomNotBookedException("Room with ID " + roomID + " is not currently booked.");
        }
		r.setAvailable(true);
		return nights *r.getPricePerNight();

	}
	
	public Room seachRoom(int roomID) {
		
		for(Room r: rooms) {
			if(r.getRoomId()==roomID) {
				return r;
			}
		}
		return null;
	}

}
