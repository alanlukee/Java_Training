package Employee_TreeSet;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		EmployeeManager em = new EmployeeManager();
		
		
		System.out.println("Welcome to Employee database.");
		System.out.println(" ");
		System.out.println("1. Add Employee");
		System.out.println("2. Remove Employee");
		System.out.println("3. Search Employee");
		System.out.println("4. Display Employees");
		System.out.println("5. Exit");
		
		System.out.println(" ");
		
		while(true) {
			int choicePick;
			System.out.println("Enter choice: ");
			choicePick = scan.nextInt();
			
			
			if(choicePick==1) {
				//adding employee
				//employeeID, name, department, and salary
				int id ;
				String name;
				String dept;
				float salary;
				System.out.println("Enter employee's ID: ");
				id = scan.nextInt();
				System.out.println("Enter employee's name: ");
				scan.nextLine();
				name = scan.nextLine();
				System.out.println("Enter employee's department: ");
				dept = scan.nextLine();
				System.out.println("Enter employee's salary: ");
				salary = scan.nextFloat();
				scan.nextLine();
				
				Employee1 newEmp = new Employee1(id, name, dept, salary);
				try {
					em.addEmployee(newEmp);
				} catch (DuplicateEmployeeException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			
			}
			else if(choicePick ==2) {
				//removing employee
				
				String name;
				System.out.println("Enter employee's name: ");
				name = scan.nextLine();
				try {
					em.removeEmployee(name);
				} catch (EmployeeNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				
			}
			else if(choicePick==3) {
				//searching for employee
				
				String name;
				System.out.println("Enter employee's name: ");
				name = scan.nextLine();
				
				try {
					em.searchEmployee(name);
				} catch (EmployeeNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			else if(choicePick==4) {
				//displaying employees
				
				em.displayEmployees();
				
			}
			else if(choicePick==5) {
				
				System.exit(0);
				
			}
			else {
				System.out.println("Invalid choice.");
			}
		}
		
		

		

		

		


	}

}
