package Online_Payment_System;

public class CreditCardPayment extends Payment {
	

	CreditCardPayment(double discountRate, double processingFee) {
		super(discountRate, processingFee);
		
	}

	@Override
	public double processPayment(double amount) {
		
		double disc = calculateDiscount(amount);
		double amtFinal = amount - disc;
		
		return amtFinal+processingFee;
	}

}
