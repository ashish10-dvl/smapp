package edu.cjc.main.sma.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import edu.cjc.main.sma.model.Student;
@Repository
public interface StudentRepositary extends JpaRepository<Student, Integer>
{

	public Student findByUsernameAndPassword(String username, String password);

	public List<Student> findAllByBatchNumber(String batchNumber);
}
