package Student_Grading_System;



@SuppressWarnings("serial")
class DuplicateStudentException extends Exception{
	DuplicateStudentException(String s){
		super(s);
	}
}

@SuppressWarnings("serial")
class StudentNotFoundException extends Exception{
	StudentNotFoundException(String s){
		super(s);
	}
}

@SuppressWarnings("serial")
class NoGradesFoundException extends Exception{
	NoGradesFoundException(String s){
		super(s);
	}
}
