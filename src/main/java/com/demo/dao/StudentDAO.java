package com.demo.dao;

import java.util.List;

import com.demo.api.Student;

public interface StudentDAO {

	List<Student> loadStudents();
	void saveStudent(Student student);
	Student getStudent(int id);
	void update(Student student);
	void deleteStudent(int id);
	
}
