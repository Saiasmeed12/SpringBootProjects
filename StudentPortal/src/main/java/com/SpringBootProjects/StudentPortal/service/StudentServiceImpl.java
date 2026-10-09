package com.SpringBootProjects.StudentPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootProjects.StudentPortal.model.Student;
import com.SpringBootProjects.StudentPortal.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepo studentRepo;
	
	@Override
	public Student createStudent(Student s) {
		return studentRepo.save(s);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentByID(Integer sid) {
		return studentRepo.findById(sid).orElseThrow();
	}

	@Override
	public Student updateStudent(Student s, Integer id) {
		Student studentInfofromDB=getStudentByID(id);
		studentInfofromDB.setAge(s.getAge());
		studentInfofromDB.setFname(s.getFname());
		studentInfofromDB.setLname(s.getLname());
		studentInfofromDB.setTotal_marks(s.getTotal_marks());		
		
		return studentRepo.save(studentInfofromDB) ;
	}

	@Override
	public void deleteStudentById(Integer id) {
		studentRepo.deleteById(id);
		
	}

	@Override
	public Student getStudentByFname(String name) {
		return studentRepo.findByFname(name);
	}

}
