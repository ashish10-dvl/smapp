package edu.cjc.main.sma.servicei;

import java.util.List;

import edu.cjc.main.sma.model.Student;

public interface StudentServiceI {

	void saveStudentDetails(Student s);
	
	public Student loginStudent(String username,String password);
	
	public List<Student> getAllStudents();

}
