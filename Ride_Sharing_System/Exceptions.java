package Ride_Sharing_System;

class NoDriverAvailableException extends Exception{
	NoDriverAvailableException(String s){
		super(s);
	}
}

class RideNotAvailableException extends Exception{
	RideNotAvailableException(String s){
		super(s);
	}
}
class RideNotCancelableException extends Exception{
	RideNotCancelableException(String s){
		super(s);
	}
	
}