package Ticketing_System_2;

public class Ticket {
	
	public double calculateTotalCost(int ticketCount , double pricePerTicket) {

		return (ticketCount * pricePerTicket);
		
	}
	
	public double calculateTotalCost(int type1_Count , double seniorPrice, int type2_Count, double type2_Price ) {
		
		return ((type1_Count*seniorPrice) +(type2_Count *type2_Price));
	}
	
	public double calculateTotalCost(int type1_Count , double type1_Price, int type2_Count, double type2_Price,int type3_Count , double type3_Price ) {
		
		return ((type1_Count*type1_Price) +(type2_Count *type2_Price)+(type3_Count *type3_Price));
	}

}
