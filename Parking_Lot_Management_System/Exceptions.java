package Parking_Lot_Management_System;

class SpotAlreadyExistsException extends Exception{
	SpotAlreadyExistsException(String s){
		super(s);
		
	}
}


class SpotUnavailableException extends Exception{
	SpotUnavailableException(String s){
		super(s);
	}
}

class SpotNotOccupiedException extends Exception{
	SpotNotOccupiedException(String s){
		super(s);
	}
}

class SpotUnsuitableException extends Exception{
	SpotUnsuitableException(String s){
		super(s);
	}
}

class SpotAlreadyOccupiedException extends Exception{
	SpotAlreadyOccupiedException(String s){
		super(s);
	}
}


