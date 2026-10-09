package com.SpringBootProjects.StudentPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootProjects.StudentPortal.model.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

	Student findByFname(String fname);
}
