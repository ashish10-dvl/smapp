package edu.cjc.main.sma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.main.sma.model.Student;
import edu.cjc.main.sma.servicei.StudentServiceI;

@Controller
public class AdminController {
	@Autowired
	StudentServiceI ssi;
	
	@RequestMapping("/")
	public String prelogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String onLogin(@RequestParam String username,@RequestParam String password,Model m) {
		if(username.equals("ADMIN") && password.equals("ADMIN")) {
			List<Student> list=ssi.getAllStudents();
			m.addAttribute("data", list);
			return "adminscreen";
		}
		else 
		
		{
			Student s=ssi.loginStudent(username, password);
			if(s!=null) {
				m.addAttribute("stu", s);
				return "studentview";
			}
			else {
				m.addAttribute("login_fail", "Enter Valid Login Details");
				return "login";
			}
			
		}
	}
	
	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student s) {
		
		ssi.saveStudentDetails(s);
		return "adminscreen";
	}
	
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam String batchNumber, Model m) 
	{
		List<Student> result=ssi.searchStudentsByBatch(batchNumber);
		if(result.size()>0) {
			m.addAttribute("data", result);
		}
		else {
			List<Student> students=ssi.getAllStudents();
			m.addAttribute("data", students);
			m.addAttribute("message", "No Records Are Available For The Batch : "+batchNumber+" ...!");
		}
	
		return "adminscreen";
		
	}

	@RequestMapping("/fees")
	public String onFees(@RequestParam int studentId, Model m) {
		
		Student s=ssi.getStudentData(studentId);
		m.addAttribute("st", s);
		return "fees";
	}
	
	@RequestMapping("/payfees")
	public String payFees(@RequestParam int studentid,@RequestParam double ammount, Model m ) {
		
		ssi.updateStudentFees(studentid,ammount);
		List<Student> students=ssi.getAllStudents();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	
	@RequestMapping("/batch")
	public String onBatch(@RequestParam int studentId, Model m) {
		
		Student s=ssi.getStudentData(studentId);
		m.addAttribute("st", s);
		return "batch";
	}
	
	@RequestMapping("/updateBatch")
	public String shiftBatch(@RequestParam int studentid,@RequestParam String batchNumber, Model m ) {
		
		ssi.updateStudentBatch(studentid,batchNumber);
		List<Student> students=ssi.getAllStudents();
		m.addAttribute("data", students);
		return "adminscreen";
	}
}
