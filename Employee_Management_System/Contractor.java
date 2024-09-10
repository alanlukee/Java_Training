package Employee_Management_System;

public class Contractor implements Payable  {
	
	//contractId (String), name (String), contractAmount (double).
	
	String contractId;
	String name;
	double contractAmount;

	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return contractAmount ;
	}

	@Override
	public void displayDetails() {
		System.out.println("Contract Id: "+contractId);
		System.out.println("Name: "+name);
		System.out.println("contractAmount: "+contractAmount);
		
	}
	

}
