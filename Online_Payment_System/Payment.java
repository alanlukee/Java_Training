package Online_Payment_System;

public abstract class Payment implements PaymentProcessor {
	
    double discountRate;
    double processingFee;
    double additionalDiscount;

    Payment(double discountRate, double processingFee, double additionalDiscount) {
        this.discountRate = discountRate;
        this.processingFee = processingFee;
        this.additionalDiscount = additionalDiscount; 
    }
    
    Payment(double discountRate, double processingFee) {
        this.discountRate = discountRate;
        this.processingFee = processingFee;
       
    }
    double calculateDiscount(double amount) {
    	double calcDisc = amount*(discountRate/100);
        return calcDisc;
    }

    double calculateDiscount(double amount, double additionalDiscount) {
    	double calcDisc = (amount*(discountRate/100))+additionalDiscount;
        return  calcDisc;
    }
    
    public abstract double processPayment(double amount);
}
