package Ticketing_System;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int seniorTicketPrice;
        int adultTicketPrice;
        int childTicketPrice;
        int noOfSeniors;
        int noOfAdults;
        int noOfChild;
        
        System.out.println("Enter Senior ticket price: ");
        seniorTicketPrice = scan.nextInt();
        System.out.println("Enter Adult ticket price: ");
        adultTicketPrice = scan.nextInt();
        System.out.println("Enter Child ticket price: ");
        childTicketPrice = scan.nextInt();
        System.out.println("Enter no: of seniors: ");
        noOfSeniors = scan.nextInt();
        System.out.println("Enter no: of adults: ");
        noOfAdults = scan.nextInt();
        System.out.println("Enter no: of children: ");
        noOfChild = scan.nextInt();
        
        System.out.println("Enter the type of movie (2D/3D):");
        String movieType = scan.next();
        scan.close();
        
        Movie movie;
        
        if (movieType.equals("2D")) {
            movie = new type_2D();
        } else if (movieType.equals("3D")) {
            movie = new type_3D();
        } else {
            System.out.println("Invalid movie type");
            return;
        }
        
        Customer senior = new SeniorCustomer();
        Customer adult = new AdultCustomer();
        Customer child = new ChildCustomer();
        
        double seniorDisc = senior.getDiscount();
        double adultDisc = adult.getDiscount();
        double childDisc = child.getDiscount();
        
        Ticket t  = new Ticket();
        
        double totChildTicketPrice = t.calculateTotalCost(noOfChild, childTicketPrice);
        double totSeniorTicketPrice = t.calculateTotalCost(noOfSeniors, seniorTicketPrice);
        double totAdultTicketPrice = t.calculateTotalCost(noOfAdults, adultTicketPrice);
        
        double totb4Disc = totChildTicketPrice+totSeniorTicketPrice+totAdultTicketPrice;
        
        double child_ticket_price_with_Discount = (1 - childDisc) * totChildTicketPrice;
        double adult_ticket_price_with_Discount = (1 - adultDisc) * totAdultTicketPrice;
        double senior_ticket_price_with_Discount = (1 - seniorDisc) * totSeniorTicketPrice;
        
        double totafterDisc = child_ticket_price_with_Discount + adult_ticket_price_with_Discount + senior_ticket_price_with_Discount;
        
        double movieIncrement = movie.movieIncrement();
        double totalTicketPrice = child_ticket_price_with_Discount + senior_ticket_price_with_Discount + adult_ticket_price_with_Discount;
        double finalTotalCost = totalTicketPrice+ (totalTicketPrice * (movieIncrement));
        
        System.out.println("Total cost before calculating discount: "+totb4Disc);
        System.out.println("Total cost before calculating discount: "+totafterDisc);
        
        
        
        System.out.println("Final total cost after movie type increment(only if 3D): " + finalTotalCost);
    }
}
