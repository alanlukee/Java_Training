package Airline_Reservation_System;

public class Flight {
    private String flightNumber;
    private String departureTime;
    private String arrivalTime;
    private int maxCapacity;
    private int bookedSeats;

    public Flight(String flightNumber, String departureTime, String arrivalTime, int maxCapacity) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.maxCapacity = maxCapacity;
        this.bookedSeats = 0;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public boolean isFull() {
        return bookedSeats >= maxCapacity;
    }

    public void bookSeat() throws FlightFullException {
        if (isFull()) {
            throw new FlightFullException("Flight " + flightNumber + " is full.");
        }
        bookedSeats++;
    }

    public void cancelSeat() throws FlightNotFoundException {
        if (bookedSeats <= 0) {
            throw new FlightNotFoundException("No seats to cancel for flight " + flightNumber + ".");
        }
        bookedSeats--;
    }

    public String toString() {
        return "Flight " + flightNumber + ": Departure " + departureTime + ", Arrival " + arrivalTime + ", Seats Booked: " + bookedSeats + "of" + maxCapacity;
    }
}
