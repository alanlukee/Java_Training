package Online_Payment_System;

public class DigitalWalletPayment extends Payment {

	DigitalWalletPayment(double discountRate, double processingFee) {
		super(discountRate, processingFee);
	}

	@Override
	public double processPayment(double amount) {
		// TODO Auto-generated method stub
		
		double disc = calculateDiscount(amount);
		double amtFinal = amount - disc;
		
		return amtFinal+processingFee;
	}

}
