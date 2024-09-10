package Employee_Management_System;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       
        FullTimeEmployee fullTimeEmp = new FullTimeEmployee();
        fullTimeEmp.employeeId = "FTE1";
        fullTimeEmp.name = "Alan Luke";
        fullTimeEmp.basicSalary = 50000;
        fullTimeEmp.bonus = 10000;

        PartTimeEmployee partTimeEmp = new PartTimeEmployee();
        partTimeEmp.employeeId = "PTE1";
        partTimeEmp.name = "Micheal Scott";
        partTimeEmp.basicSalary = 0;
        partTimeEmp.hoursWorked = 120;
        partTimeEmp.hourlyRate = 50;

        Contractor contractor = new Contractor();
        contractor.contractId = "C1";
        contractor.name = "Mike Tyson";
        contractor.contractAmount = 80000;

       
        List<Payable> employees = new ArrayList<>();
        employees.add(fullTimeEmp);
        employees.add(partTimeEmp);
        employees.add(contractor);

        
        for (Payable emp : employees) {
            emp.displayDetails();
            System.out.println("Salary: " + emp.calculateSalary());
            System.out.println(" ");
        }
    }
}
