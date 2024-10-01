package Hotel_Reservation_System;

import java.util.List;

class addRoomThread implements Runnable{
    private HotelManager manager;
    private Room room;
    
    public addRoomThread(HotelManager manager, Room room) {
    	this.manager = manager;
    	this.room = room;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			manager.addRoom(room);
		} catch (RoomAlreadyExistsException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	public HotelManager getManager() {
		return manager;
	}

	public void setManager(HotelManager manager) {
		this.manager = manager;
	}
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}

class bookRoomThread implements Runnable{
	
	private HotelManager manager;
	private int roomID;
	
	public bookRoomThread(HotelManager manager, int roomID) {
		
		this.manager = manager;
		this.roomID = roomID;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			manager.bookRoom(roomID);
		} catch (RoomNotAvailableException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	public HotelManager getManager() {
		return manager;
	}

	public void setManager(HotelManager manager) {
		this.manager = manager;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	
}

class cancelRoomThread implements Runnable {
    private HotelManager manager;
    private int roomID;

    public cancelRoomThread(HotelManager manager, int roomID) {
        this.manager = manager;
        this.roomID = roomID;
    }

    @Override
    public void run() {
        try {
            manager.cancelBooking(roomID);
        } catch (RoomNotBookedException e) {
            System.out.println(e.getMessage());
        } catch (RoomNotAvailableException e) {
			// TODO Auto-generated catch block
            System.out.println(e.getMessage());
		}
    }
}

class viewAvailableRoomThread implements Runnable{
	
	private HotelManager manager;
	public viewAvailableRoomThread(HotelManager manager) {
		this.manager = manager;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<Room> listRooms = manager.viewAvailableRooms();
		System.out.println(" Available rooms are: ");
		for(Room i : listRooms) {
			System.out.println(i);
		}
		
	}
	
	public HotelManager getManager() {
		return manager;
	}

	public void setManager(HotelManager manager) {
		this.manager = manager;
	}
}

class checkOutRoomThread implements Runnable{
	private HotelManager manager;
	private int nights;
	private int roomID;
	
	public checkOutRoomThread(HotelManager manager,int roomID,int nights) {
		this.manager = manager;
		this.roomID = roomID;
		this.nights = nights;
	}
	

	@Override
	public void run() {
		
		try {
			double totCost = manager.checkout(roomID, nights);
			System.out.println("total cost: "+totCost);
		} catch (RoomNotBookedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public HotelManager getManager() {
		return manager;
	}


	public void setManager(HotelManager manager) {
		this.manager = manager;
	}


	public int getNights() {
		return nights;
	}


	public void setNights(int nights) {
		this.nights = nights;
	}


	public int getRoomID() {
		return roomID;
	}


	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	
}


	
	