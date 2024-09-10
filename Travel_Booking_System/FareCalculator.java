package Travel_Booking_System;

public class FareCalculator {
	
	double busRate;
	double trainRate;
	double flightRate;
	
	public double calculateFare(double distance,double baseFarePerKm ) {
		

		return (distance * baseFarePerKm);
		
	}
	
	public double calculateFare(double distance,double baseFarePerKm,double discount ) {
		
		return(calculateFare(distance,baseFarePerKm) * (1-(discount/100) ));
		
	}
	
	public double calculateFare(double distance,double baseFarePerKm,double discount, String travelMode ) {
		
		double totalFare = 0;
		
		if (travelMode.toLowerCase().equals("flight")) {
	        totalFare =(calculateFare(distance, baseFarePerKm)*(1-(discount/100))+flightRate);
	    } else if (travelMode.toLowerCase().equals("bus")) {
	        totalFare =(calculateFare(distance, baseFarePerKm)*(1-(discount/100))+busRate);
	    } else if (travelMode.toLowerCase().equals("train")) {
	        totalFare =(calculateFare(distance, baseFarePerKm)*(1-(discount / 100))+trainRate);
	    } else {
	        System.out.println("Invalid travel mode");
	    }
	    
	    return totalFare; 	
		
	}

}
