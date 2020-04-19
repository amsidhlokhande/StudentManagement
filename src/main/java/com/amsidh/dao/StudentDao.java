package com.amsidh.dao;

import java.util.List;

import com.amsidh.model.Student;

public interface StudentDao {
	public void addStrudent(Student student);

	public void deleteStudent(Student student);

	public void updateStudent(Student student);

	public Student getStudent(Integer id);

	public List<Student> getAllStudents();

}
