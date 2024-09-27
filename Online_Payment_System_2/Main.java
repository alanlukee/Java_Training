package Online_Payment_System_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Processing details for each payment method");
		System.out.println(" ");
		System.out.println("Credit Card Payment");
		System.out.println("--------------------");
		Payment ccp = new CreditCardPayment(4, 100);
		System.out.println("Final Payment: "+ccp.processPayment(2500));
		System.out.println(" ");

		System.out.println("Dedit Card Payment");
		System.out.println("--------------------");
		Payment dcp = new DebitCardPayment(3, 150, 45);
		System.out.println("Final Payment: "+dcp.processPayment(2500));
		System.out.println(" ");

		System.out.println("Digital Wallet Payment");
		System.out.println("--------------------");
		Payment dwp = new DigitalWalletPayment(2, 130);
		System.out.println("Final Payment: "+dwp.processPayment(2500));
		System.out.println(" ");

		scan.close();
		
	}

}
