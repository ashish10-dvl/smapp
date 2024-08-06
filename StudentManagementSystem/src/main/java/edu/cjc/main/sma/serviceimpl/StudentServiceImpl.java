package edu.cjc.main.sma.serviceimpl;

import java.util.List;
import java.util.Optional;

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
	
	@Override
	public List<Student> searchStudentsByBatch(String batchNumber) {
		List<Student> batchStudents=sr.findAllByBatchNumber(batchNumber);
		return batchStudents;
	}
	@Override
	public Student getStudentData(int studentId) {
		Optional<Student> op=sr.findById(studentId);
		return op.get();
	}
	@Override
	public void updateStudentFees(int studentid, double ammount) {
		Optional<Student> op=sr.findById(studentid);
		
			Student s=op.get();
			double oldfees=s.getFeesPaid();
			s.setFeesPaid(oldfees+ammount);
			sr.save(s);
		
	}
	@Override
	public void updateStudentBatch(int studentid, String batchNumber) {
		Optional<Student> op=sr.findById(studentid);
		Student s=op.get();
		s.setBatchNumber(batchNumber);
		sr.save(s);
		
	}

	
}
