package Employee_Management_System;

public class PartTimeEmployee extends Employee {
	
	//hoursWorked (int) and hourlyRate (double)
	
	int hoursWorked;
	double hourlyRate;

	@Override
	public double calculateSalary() {
		
		double salary = hoursWorked * hourlyRate;
		
		return salary;
	}

}
