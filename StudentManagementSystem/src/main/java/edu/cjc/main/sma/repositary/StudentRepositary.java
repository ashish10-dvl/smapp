package edu.cjc.main.sma.repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import edu.cjc.main.sma.model.Student;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface StudentRepositary extends JpaRepository<Student, Integer>
{

	public Student findByUsernameAndPassword(String username, String password);

	public List<Student> findAllByBatchNumber(String batchNumber);

	public Optional<Student> removeBystudentId(int studentid);

	
}
