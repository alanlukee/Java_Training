package Online_Payment_System;

public class DebitCardPayment extends Payment {

	DebitCardPayment(double discountRate, double processingFee, double additionalDiscount) {
		
        super(discountRate, processingFee,additionalDiscount);
        
    }

	@Override
	public double processPayment(double amount) {
		// TODO Auto-generated method stub
		
		double disc = calculateDiscount(amount,additionalDiscount);
		double amtFinal = amount - disc;
		
		return amtFinal+ processingFee;
	}

}
