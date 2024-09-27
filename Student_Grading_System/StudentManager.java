package Student_Grading_System;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

//add student
//remove student.
//add grades for student.
//calc gpa.
//display students.


@SuppressWarnings("rawtypes")
class MyComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		String str1 = s1.getName();
		String str2 = s2.getName();
		
		return str1.compareTo(str2);
	}
	
}

public class StudentManager {
	
	
	@SuppressWarnings("unchecked")
	TreeSet<Student> students = new TreeSet<Student>(new MyComparator());
	
	public void addStudent(Student s) throws DuplicateStudentException {
		
		boolean foundStudent= false;
		for(Student i : students) {
			if(i.equals(s)) {
				foundStudent = true;
				throw new DuplicateStudentException("Student already exists.");
			}
		}
		if(foundStudent == false) {
			students.add(s);
			System.out.println("Student with name "+s.getName()+" added");
		}

	}
	
	public void removeStudent(String name) throws StudentNotFoundException {
		
		boolean foundStudent = false;
		
		if(students.isEmpty()) {
			throw new StudentNotFoundException("No students. Empty");
		}
		
		Iterator<Student> itr = students.iterator();
		while(itr.hasNext()) {
			Student s = itr.next();
			if(s.getName().equals(name)){
				itr.remove();
				foundStudent = true;
				System.out.println("Student with name "+s.getName()+" has been removed.");
				break;
			}
		}
		if(foundStudent ==false) {
			throw new StudentNotFoundException("Student not found.");
		}
	}
	
	public void searchStudent(String name) throws StudentNotFoundException {
		
		boolean foundStudent = false;
		
		if(students.isEmpty()) {
			throw new StudentNotFoundException("No students. Empty");
		}
		
		Iterator<Student> itr = students.iterator();
		
		while(itr.hasNext()) {
			Student s = itr.next();
			if(s.getName().equals(name)) {
				foundStudent = true;
				System.out.println("Student found. Printing details..");
				System.out.println(" ");
				System.out.println(s);

			}
		}
		if(foundStudent ==false) {
			throw new StudentNotFoundException("Could not find student.");
		}

	}

	public void addGradeForStudent(String name, float grade) throws StudentNotFoundException {
		boolean foundStudent = false;
		
		if(students.isEmpty()) {
			throw new StudentNotFoundException("No students. Empty");
		}
		
		Iterator<Student> itr = students.iterator();
		while(itr.hasNext()) {
			Student s = itr.next();
			if(s.getName().equals(name)) {
				foundStudent = true;
				s.getGrades().add(grade);
			}
		}
		if(foundStudent ==false) {
			throw new StudentNotFoundException("Could not find student");
		}
		
	}
	
	public void gpaCalculator() throws StudentNotFoundException, NoGradesFoundException {

		if(students.isEmpty()) {
			throw new StudentNotFoundException("No students. Empty");
		}
		else {
			Iterator<Student> itr = students.iterator();
			while(itr.hasNext()) {
				float total = 0;
				float gpa=0;
				Student s = itr.next();
				
				if(s.getGrades().isEmpty()) {
					throw new NoGradesFoundException("No grades found");
				}
				else {
					for(float i :s.getGrades()) {
						total = total + i;
					}
					gpa = total/(s.getGrades().size());
					System.out.println("GPA of "+s.getName()+" is "+gpa);
				}
				//armada
			}

		}
		
	}
	
	public void displayStudents() throws StudentNotFoundException {
		
		if(students.isEmpty()) {
			throw new StudentNotFoundException("No students. Empty");
		}
		
		for(Student s: students) {
			System.out.println(s);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 

}
