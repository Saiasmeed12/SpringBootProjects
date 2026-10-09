package com.SpringBootProjects.StudentPortal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootProjects.StudentPortal.model.Student;
import com.SpringBootProjects.StudentPortal.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentservice;
	
	@GetMapping("/welcome")
	String Welcome() {
		return "Welcome to Student Portal";
	}
	
	@GetMapping("/getAllStudents")
	List<Student> getAllStudents(){
		return studentservice.getAllStudent();
		
	}
	
	@GetMapping("/gs/{sid}")
	 Student getStudent(@PathVariable Integer sid){
		return studentservice.getStudentByID(sid);
	}
	
	@GetMapping("/getStudent/fname/{fname}")
	Student getStudent(@PathVariable String fname) {
	return studentservice.getStudentByFname(fname);
	}
	
	
	@PostMapping("/studata")
	Student createStudent(@RequestBody Student s) {
		return studentservice.createStudent(s);
		
	}
	
	@PutMapping("update/{sid}")
	Student	updateStudent(@RequestBody Student s,@PathVariable Integer sid){
		return studentservice.updateStudent(s, sid);
	}
	
	
	@DeleteMapping("/delete/{sid}")
	String deleteStudent(@PathVariable Integer sid){
		studentservice.deleteStudentById(sid);
		return "Deleted"+ sid+"Sucessfully";
	}
	
	
	
	
}
