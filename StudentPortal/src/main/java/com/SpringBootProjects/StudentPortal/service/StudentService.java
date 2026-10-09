package com.SpringBootProjects.StudentPortal.service;

import java.util.List;

import com.SpringBootProjects.StudentPortal.model.Student;

public interface StudentService {

	public abstract Student createStudent(Student s);
	
	List<Student> getAllStudent();
	
	Student getStudentByID(Integer sid);
	
	Student updateStudent(Student student , Integer id);
	
	void deleteStudentById(Integer id);
	
	Student getStudentByFname(String name);
	
}
