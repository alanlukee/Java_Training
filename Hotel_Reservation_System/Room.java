package Hotel_Reservation_System;

//roomId, roomType, pricePerNight, and isAvailable.

public class Room {
	private int roomId;
	private String roomType;
	private double pricePerNight;
	private boolean isAvailable;
	
	
	public Room(int roomId, String roomType, double pricePerNight) {
		this.roomId = roomId;
		this.roomType = roomType;
		this.pricePerNight = pricePerNight;
		this.isAvailable = true;
		
	}
	
	public String toString() {
		return("[ RoomID: "+roomId+", Type of Room: "+roomType+", Per night: "+pricePerNight+", Availability: "+isAvailable+" ]");
	}
	
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}
		if(o instanceof Room) {
			Room r2 = (Room) o;
			if(this.roomId==r2.roomId) {
				return true;
			}
		}
		return false;
	}
	
	public int hashCode() {
		return Integer.hashCode(roomId);
	}
	
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getTypeOfRoom() {
		return roomType;
	}
	public void setTypeOfRoom(String roomType) {
		this.roomType = roomType;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	
	

}
