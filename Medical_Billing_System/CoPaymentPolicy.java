package Medical_Billing_System;

public class CoPaymentPolicy {
    private double coPay; 
    
    public CoPaymentPolicy(double coPay) {
        this.coPay = coPay;
    }
    
    public double getCoPayPercentage() {
        return coPay;
    }
}
