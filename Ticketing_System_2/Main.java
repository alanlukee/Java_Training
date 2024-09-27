package Ticketing_System_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double seniorPrice = 150;
		double adultPrice = 100;
		double childPrice = 70;

		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Price details: ");
		
		System.out.println("Senior ticket price: "+seniorPrice);
		System.out.println("Adult ticket price: "+adultPrice);
		System.out.println("Child ticket price: "+childPrice);

		System.out.println(" ");
		
		System.out.println("Welcome to ticketing system");
		System.out.println("-----------------------------");
		
		
		System.out.println("Tickets for whom? (Senior,Adult,Child)");
		String customers = scan.nextLine();
		
	
		
		System.out.println("Enter which movietype: (2D/3D)");
		String movieType = scan.nextLine();

		
		String [] customerArray = customers.split(","); 
		List<String> customerList = new ArrayList<String>();
		

		for(String i : customerArray) {
			
			customerList.add(i.trim());
		}
		
		List<Customer> customerObjects = new ArrayList<>();
		
		int seniorTickets = 0;
		int adultTickets = 0;
		int childTickets = 0;

		double seniorDisc = 0;
		double adultDisc = 0;
		double childDisc = 0;
		
		if(customerList.contains("Senior")) {
			Customer senior = new SeniorCustomer("pqr");
			System.out.println("Enter senior ticket count: ");
			seniorTickets = scan.nextInt();
			seniorDisc = senior.getDiscount();
			customerObjects.add(senior);
		}
		if(customerList.contains("Adult")) {
			Customer adult = new AdultCustomer("xyz");
			System.out.println("Enter adult ticket count: ");
			adultTickets = scan.nextInt();
			adultDisc = adult.getDiscount();
			customerObjects.add(adult);

		}
		if(customerList.contains("Child")) {
			Customer child = new ChildCustomer("abcd");
			System.out.println("Enter child ticket count: ");
			childTickets = scan.nextInt();
			childDisc = child.getDiscount();
			customerObjects.add(child);

		}
		
		Movie movie = null;
		
		if(movieType.equalsIgnoreCase("2d")) {
			
			movie = new type_2D();
			
			
		}
		else if(movieType.equalsIgnoreCase("3d")) {
			movie = new type_3D();

		}
		
		double movieInc = movie.movieIncrement();
		
		Ticket t = new Ticket();
		int count = 0;
		
		for(String i : customerList) {
			count = count +1;
		}
		
		if(count ==1) {
			
				System.out.println("Senior only total cost "+ (int)((1 - seniorDisc) *t.calculateTotalCost(seniorTickets,seniorPrice)+movieInc)+" rupees");
				System.out.println("Adult only total cost "+ (int)((1 - adultDisc) *t.calculateTotalCost(adultTickets,adultPrice)+movieInc)+" rupees");
				System.out.println("Child only total cost "+ (int)((1 - childDisc) *t.calculateTotalCost(childTickets,childPrice)+movieInc)+" rupees");

		}
		else if (count ==2) {
			System.out.println("Senior + Adult total cost: "+(int)(t.calculateTotalCost(seniorTickets, seniorPrice,adultTickets , adultPrice)+movieInc)+" rupees");
			System.out.println("Senior + Child total cost: "+ (int)(t.calculateTotalCost(seniorTickets, seniorPrice,childTickets , childPrice)+movieInc)+" rupees");
			System.out.println("Adult + Child total cost: "+ (int)(t.calculateTotalCost(adultTickets, adultPrice,childTickets , childPrice)+movieInc)+" rupees");
		}
		else if (count == 3) {
			System.out.println("Senior + Adult + Child total cost: "+ (int)(t.calculateTotalCost(seniorTickets, seniorPrice, adultTickets, adultPrice, childTickets, childPrice)+movieInc)+" rupees");
		}
		

	}

}
