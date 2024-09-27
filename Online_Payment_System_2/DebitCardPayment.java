package Online_Payment_System_2;

public class DebitCardPayment extends Payment {

	DebitCardPayment(double discountRate, double processingFee, double additionalDiscount) {
		super(discountRate, processingFee, additionalDiscount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double processPayment(double amount) {
		// TODO Auto-generated method stub
		double disc = calculateDiscount(amount,additionalDiscount );
		double finalAmt = amount - disc;
		return finalAmt+processingFee;
	}

}
