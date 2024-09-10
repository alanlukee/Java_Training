package Medical_Billing_System;

import java.util.List;

public class BillingCalculator {
    
    public double calculateBill(List<MedicalService> services) {
        double totalBill = 0;
        for (MedicalService service : services) {
            totalBill += service.getCost();
        }
        return totalBill;
    }
    
 
    public double calculateBill(List<MedicalService> services, InsurancePlan insurance) {
        double totalBill = 0;
        for (MedicalService service : services) {
            totalBill += service.getCost();
        }
        double insuranceCoverage = totalBill * (insurance.getCoveragePercentage() / 100);
        return totalBill - insuranceCoverage; 
    }
    
 
    public double calculateBill(List<MedicalService> services, InsurancePlan insurance, CoPaymentPolicy policy) {
    	
        double totalBill = 0;
        for (MedicalService service : services) {
            totalBill += service.getCost();
        }
        double insuranceCoverage = totalBill * (insurance.getCoveragePercentage() / 100);
        double billAfterInsurance = totalBill - insuranceCoverage;
        
        
        double coPayAmount = billAfterInsurance * (policy.getCoPayPercentage() / 100);
        return billAfterInsurance + coPayAmount; 
    }
}
