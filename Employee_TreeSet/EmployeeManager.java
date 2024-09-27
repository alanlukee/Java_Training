package Employee_TreeSet;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;



class MyComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		
		
		Employee1 c1=(Employee1)o1;
		Employee1 c2=(Employee1)o2;
        String s1=c1.getName();
        String s2=c2.getName();
        
        return s1.compareTo(s2);
	
	}
	
}

public class EmployeeManager {
	
	TreeSet<Employee1> employees = new TreeSet<Employee1>(new MyComparator());
	
	
	public void addEmployee(Employee1 e) throws DuplicateEmployeeException {
		
		boolean foundEmployee  = false;
		for(Employee1 i : employees) {
			if(i.equals(e)) {
				foundEmployee = true;
				throw new DuplicateEmployeeException("Employee already exists.");
			}
		}
		if(foundEmployee == false) {
			employees.add(e);
			System.out.println("Employee added to database.");
		}

	}
	
	public void removeEmployee(String name) throws EmployeeNotFoundException {
		boolean foundEmployee = false;
        Iterator<Employee1> itr = employees.iterator();
        while (itr.hasNext()) {
            Employee1 emp = itr.next();
            if (emp.getName().equalsIgnoreCase(name)) {
                itr.remove();
                foundEmployee = true;
                System.out.println("Employee removed from database.");
                break;
            }
        }
        if (!foundEmployee) {
            throw new EmployeeNotFoundException("Employee not found.");
        }
		
	}
	
	public void searchEmployee(String name) throws EmployeeNotFoundException {
        for (Employee1 emp : employees) {
            if (emp.getName().equalsIgnoreCase(name)) {
                System.out.println("Employee found: " + emp);
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee not found.");
	}
	
	public void displayEmployees() {
		if (employees.isEmpty()) {
            System.out.println("No employees in the database.");
        } else {
            System.out.println("Employee List:");
            for (Employee1 emp : employees) {
                System.out.println(emp);
            }
        }
		
	}
	
	public void salaryCalculator() {
		
        if (employees.isEmpty()) {
            System.out.println("No employees in database.");
            return;
        }
        
        float totalSalary = 0;
        for (Employee1 emp : employees) {
            totalSalary += emp.getSalary();
        }
        
        float averageSalary = totalSalary / employees.size();
        System.out.println("Total Salary: " + totalSalary);
        System.out.println("Average Salary: " + averageSalary);
    }

}

