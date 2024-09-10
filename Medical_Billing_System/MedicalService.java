package Medical_Billing_System;

public abstract class MedicalService {
	
	String medicalServiceName;
	
	MedicalService(String medicalServiceName){
		
		this.medicalServiceName = medicalServiceName;
		
	}
	
	public abstract double getCost();
}
