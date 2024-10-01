package Hotel_Reservation_System;


@SuppressWarnings("serial")
class RoomAlreadyExistsException extends Exception{
	RoomAlreadyExistsException(String s){
		super(s);
	}
}

@SuppressWarnings("serial")
class RoomNotAvailableException extends Exception{
	RoomNotAvailableException(String s){
		super(s);
	}
}

@SuppressWarnings("serial")
class RoomNotBookedException extends Exception{
	RoomNotBookedException(String s){
		super(s);
	}
}
