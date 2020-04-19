package com.amsidh.service;

import java.util.List;

import com.amsidh.model.Student;

public interface StudentService {
	public void addStrudent(Student student);

	public void deleteStudent(Student student);

	public void updateStudent(Student student);

	public Student getStudent(Integer id);

	public List<Student> getAllStudents();
}
