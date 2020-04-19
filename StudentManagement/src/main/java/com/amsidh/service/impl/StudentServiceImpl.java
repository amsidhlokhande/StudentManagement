package com.amsidh.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amsidh.dao.StudentDao;
import com.amsidh.model.Student;
import com.amsidh.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    
	@Autowired
	private StudentDao studentDao;

	@Override
	public void addStrudent(Student student) {
		studentDao.addStrudent(student);

	}

	@Override
	public void deleteStudent(Student student) {
		studentDao.deleteStudent(student);

	}

	@Override
	public Student getStudent(Integer id) {

		return studentDao.getStudent(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
		
	}
  
}
