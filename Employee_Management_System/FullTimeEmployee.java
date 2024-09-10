package Employee_Management_System;

public class FullTimeEmployee extends Employee {

	double bonus;
	@Override
	public double calculateSalary() {
		double salary = basicSalary + bonus;
		return salary;
	}

}
