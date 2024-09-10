package Employee_Management_System;

public abstract class Employee implements Payable {
	
	String employeeId;
	String name;
	double basicSalary;
	
	public void displayDetails() {
		System.out.println("Employee id: "+employeeId);
		System.out.println("Employee name: "+name);
		
	}
	public abstract double calculateSalary();

}
