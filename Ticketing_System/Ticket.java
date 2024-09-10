package Ticketing_System;

public class Ticket {
	
	public double calculateTotalCost(int noOfTickets, double ticketPrice) {
		
		return noOfTickets*ticketPrice;
	}
	
	public double calculateTotalCost(int noOfChildTickets, int noOfAdultTickets, 
			                         int noOfSeniorTickets, double childTicketPrice,
			                         double adultTicketPrice, double seniorTicketPrice) {
		
		return ((noOfChildTickets*childTicketPrice) + 
				(noOfSeniorTickets*seniorTicketPrice)+
				(noOfAdultTickets*adultTicketPrice)) ;
		
		
		
		
												
										
		
	}
	

}
