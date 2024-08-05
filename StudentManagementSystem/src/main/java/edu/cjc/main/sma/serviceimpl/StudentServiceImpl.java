package edu.cjc.main.sma.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.main.sma.model.Student;
import edu.cjc.main.sma.repositary.StudentRepositary;
import edu.cjc.main.sma.servicei.StudentServiceI;
@Service
public class StudentServiceImpl implements StudentServiceI
{
	@Autowired
	StudentRepositary sr;
	@Override
	public void saveStudentDetails(Student s) {
		sr.save(s);
		
	}
	@Override
	public Student loginStudent(String username, String password) {
		
		return sr.findByUsernameAndPassword(username, password);
	}
	@Override
	public List<Student> getAllStudents() {
		
		return sr.findAll();
	}

	
}
