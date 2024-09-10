package Medical_Billing_System;

public class Surgery extends MedicalService {

	Surgery(String medicalServiceName) {
		super(medicalServiceName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 100;
	}

}
