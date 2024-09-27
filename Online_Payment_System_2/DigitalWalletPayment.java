package Online_Payment_System_2;

public class DigitalWalletPayment extends Payment {

	DigitalWalletPayment(double discountRate, double processingFee) {
		super(discountRate, processingFee);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double processPayment(double amount) {
		
		double disc = calculateDiscount(amount);
		double finalAmt = amount - disc;
		return finalAmt+processingFee;
	
	}

}
