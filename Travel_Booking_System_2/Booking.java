package Travel_Booking_System_2;

public abstract class Booking {
	
	String bookingName;
	
	Booking(String bookingName){
		this.bookingName = bookingName;
	}
	
	public abstract double getCost();

}
