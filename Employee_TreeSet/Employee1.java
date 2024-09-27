package Employee_TreeSet;



//employeeID, name, department, and salary
public class Employee1 {
	
	private int employeeID;
	private String name;
	private String department;
	private float salary;
	
	Employee1(int employeeID,String name, String department,float salary){
		
		this.employeeID = employeeID;
		this.name = name;
		this.department = department;
		this.salary = salary;
		
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	//toString(), equals(), and hashCode()
	
	public String toString() {
		
		return ("Employee ID: "+employeeID+" Name: "+name+" Department: "+department+ "Salary: "+salary);
		
	}
	
	public int hashCode() {
		return employeeID;
	}
	
	public boolean equals(Object o) {
		
		if(this==o)
			
		return true;
		
		if(o instanceof Employee1) {
			
			Employee1 s2=(Employee1)o;
			
			if( name.equals(s2.name) && employeeID==s2.employeeID)     {
				return true;
			}
			else
				return false;
		}
		
		return false;
		}
	
    public int compareTo(Employee1 e) {
    	
        return this.name.compareToIgnoreCase(e.name);  
    }

	
	
	

}
