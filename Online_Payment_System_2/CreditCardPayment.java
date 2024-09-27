package Online_Payment_System_2;

public class CreditCardPayment extends Payment {

	CreditCardPayment(double discountRate, double processingFee) {
		super(discountRate, processingFee);
		
	}

	@Override
	public double processPayment(double amount) {
		
		double disc = calculateDiscount(amount);
		double finalAmt = amount - disc;
		return finalAmt+processingFee;
	}

}

