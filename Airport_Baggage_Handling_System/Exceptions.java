package Airport_Baggage_Handling_System;

class BagAlreadyCheckedInException extends Exception{
	BagAlreadyCheckedInException(String s){
		super(s);
	}
}


class UnableToLoadBagException extends Exception{
	UnableToLoadBagException(String s){
		super(s);
	}
}

class BagNotRetrievableException extends Exception{
	BagNotRetrievableException(String s){
		super(s);
	}
}

class FlightBagWeightExceeded extends Exception{
	FlightBagWeightExceeded(String s){
		super(s);
	}
}

class FlightNotFoundException extends Exception{
	FlightNotFoundException(String s){
		super(s);
	}
}

