package Order_Management_System;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Order Management System");
		Scanner scan = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("enter order amount");
		double orderAmt = scan.nextDouble();
		System.out.println("enter customer type: 1. Regular Customer, 2. Premium Customer, 3. Coorporate Customer ");
		int customerNo = scan.nextInt();
		scan.close();
		String custType = null;
		double disc = 0.0;
		
		if(customerNo ==1) {
			System.out.println("Hi Regular Customer");
			custType = "Regular";
			Customer customer = new RegularCustomer(101);
			disc = customer.getDiscountRate();
		}
		else if (customerNo ==2) {
			System.out.println("Hi Premium Customer");
			custType = "Premium";
			Customer customer = new PremiumCustomer(102);
			disc = customer.getDiscountRate();
			
		}
		else if (customerNo ==3) {
			System.out.println("Hi Coorporate Customer");
			custType = "Coorporate";
			Customer customer = new CorporateCustomer(103);
			disc = customer.getDiscountRate();
			
		}
		else {
			System.out.println("invalid customer");
		}
		
		BillCalculator calc = new BillCalculator(orderAmt,disc,custType);
		
		System.out.println("Final Amount: "+calc.calculateBill(orderAmt)+" rupees");
		System.out.println("Discount applied: "+disc);
		System.out.println("Final Amount after discount: "+calc.calculateBill(orderAmt, disc, custType)+" rupees");	

	}

}
