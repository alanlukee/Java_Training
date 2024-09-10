package Online_Payment_System;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CreditCardPayment ccp = new CreditCardPayment(1, 2);
		DebitCardPayment dcp = new DebitCardPayment(3, 4, 4);
		DigitalWalletPayment dwp = new DigitalWalletPayment(5, 6);
		
		
		System.out.println("CreditCard: "+ccp.processPayment(500));
		System.out.println("DebitCard: "+dcp.processPayment(500));
		System.out.println("DigitalWallet: "+dwp.processPayment(500));
		
	}

}
