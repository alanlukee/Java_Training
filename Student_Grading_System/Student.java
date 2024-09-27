package Student_Grading_System;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private int studentID;
	private String name;
	private List<Float> grades;

	
	Student(int studentID, String name,List<Float> grades  ){
		
		this.studentID = studentID;
		this.name = name;
		this.grades = new ArrayList<Float>();
		
	}
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Float> getGrades() {
		return grades;
	}

	public void setGrades(List<Float> grades) {
		this.grades = grades;
	}
	
	public String toString() {
		return("[ StudentID: "+studentID+", Student Name: "+name+", Grades: "+grades+" ]");
	}
	
	public boolean equals(Object o) {
		
		if(this==o) {
			return true;
		}
		if(o instanceof Student) {
			
			Student s1 = (Student) o;
			if(this.name.equals(s1.name)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}

	}
	
	public int hashCode() {
		return this.name.hashCode();
	}
	
	public int compareTo(Student s) {
		return this.name.compareTo(s.name);
	}

}
