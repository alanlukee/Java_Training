package Travel_Booking_System_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BookingCalculator calc = new BookingCalculator();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter booking's required(FlightBooking, HotelBooking, RentalCarBooking)-comma separated: ");
		String bookings = scan.nextLine();
		System.out.println("Enter discount code: ");
		String discountCode = scan.nextLine();


		List<String> bookList = new ArrayList<>();

		String[] bookingArray = bookings.split(",");
		
		for (String item : bookingArray) {
			bookList.add(item.trim());
			
		}
		
		List<Booking> bookingList = new ArrayList<>();

        
        if(bookList.contains("FlightBooking")) {
        	Booking flight = new FlightBooking("Flight");
        
        	bookingList.add(flight);
        }
        if(bookList.contains("HotelBooking")) {
        	Booking hotel = new HotelBooking("Hotel");
        	
        	bookingList.add(hotel);
        }
        if(bookList.contains("RentalCarBooking")) {
        	Booking rentalcar = new RentalCarBooking("Rental Car");
        	
        	bookingList.add(rentalcar);
        }
        
        double withoutDiscountAndTax = calc.calculateTotalCost(bookingList);
        double withDiscount = calc.calculateTotalCost(bookingList,discountCode );
        double withDiscountAndTax = calc.calculateTotalCost(bookingList, discountCode, 10);
        
        
        System.out.println(" ");
        System.out.println("Travel_Booking_System");
        System.out.println(" ");
        System.out.println("Bookings are: ");
        System.out.println(" ");

        
        for (Booking i : bookingList) {
        	System.out.println(i.bookingName);
        }
        System.out.println(" ");
        
        System.out.println("Rate without discount and tax: "+withoutDiscountAndTax+" rupees");
        System.out.println("Rate with discount: "+withDiscount+" rupees");
        System.out.println("Rate with discount and tax: "+withDiscountAndTax+" rupees");

        
        scan.close();
	}

}
