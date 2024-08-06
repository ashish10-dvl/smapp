package edu.cjc.main.sma.servicei;

import java.util.List;

import edu.cjc.main.sma.model.Student;

public interface StudentServiceI {

	void saveStudentDetails(Student s);
	
	public Student loginStudent(String username,String password);
	
	public List<Student> getAllStudents();
	
	public List<Student> searchStudentsByBatch(String batchNumber);

	Student getStudentData(int studentId);

	void updateStudentFees(int studentid, double ammount);

	void updateStudentBatch(int studentid, String batchNumber);

}
