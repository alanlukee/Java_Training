package Medical_Billing_System;

public class InsurancePlan {
    private double coverage; 
    
    public InsurancePlan(double coverage) {
        this.coverage = coverage;
    }
    
    public double getCoveragePercentage() {
        return coverage;
    }
}
