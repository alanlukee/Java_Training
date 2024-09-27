package Student_Grading_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Student Grading System");
		System.out.println(" ");
		System.out.println("1. Add Student.");
		System.out.println("2. Remove Student.");
		System.out.println("3. Add grade for student.");
		System.out.println("4. Calculate GPA for student.");
		System.out.println("5. Display students");
		System.out.println("6. Exit");
		System.out.println(" ");
		
		try (Scanner scan = new Scanner(System.in)) {
			StudentManager sm = new StudentManager();

			while(true) {
				
				int choicePick;
				System.out.println("Enter choice: ");
				choicePick = scan.nextInt();
				scan.nextLine();
				
				
				if(choicePick==1) {
					
					//add student
					int studentid;
					String name;
					List<Float> gradeList = new ArrayList<Float>();
					System.out.println("Enter student id: ");
					studentid = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter student name: ");
					name = scan.nextLine();
					Student s = new Student(studentid, name, gradeList);
					try {
						sm.addStudent(s);
					} catch (DuplicateStudentException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
						
				}
				
				else if(choicePick ==2) {
					//remove student
					String name;
					System.out.println("Enter student name: ");
					name = scan.nextLine();
					try {
						sm.removeStudent(name);
					} catch (StudentNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
					
				}
				else if(choicePick==3) {
					//add grade for student
					String name;
					float grade;
					System.out.println("Enter student name: ");
					name = scan.nextLine();
					System.out.println("Enter grade: ");
					grade = scan.nextFloat();
					scan.nextLine();
					try {
						sm.addGradeForStudent(name, grade);
					} catch (StudentNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
				}
				else if(choicePick ==4) {
					//calc gpa for student.
					try {
						sm.gpaCalculator();
					} catch (StudentNotFoundException | NoGradesFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				else if(choicePick == 5) {
					//display students.
					try {
						sm.displayStudents();
					} catch (StudentNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				else if(choicePick==6) {
					
					System.exit(0);
				}
				else {
					System.out.println("Invalid choice");
				}
				
				
			}
		}



	}

}
