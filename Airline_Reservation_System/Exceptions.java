package Airline_Reservation_System;

class FlightNotFoundException extends Exception {
    public FlightNotFoundException(String message) {
        super(message);
    }
}


class FlightFullException extends Exception {
    public FlightFullException(String message) {
        super(message);
    }
}