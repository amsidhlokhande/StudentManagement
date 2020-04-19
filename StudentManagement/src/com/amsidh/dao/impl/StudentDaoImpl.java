package com.amsidh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amsidh.dao.StudentDao;
import com.amsidh.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addStrudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(student);
		session.flush();
		transaction.commit();

	}

	@Override
	public void deleteStudent(Student student) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(student);
		session.flush();
		transaction.commit();
	}

	@Override
	public Student getStudent(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student) session.load(Student.class, id);
		session.flush();
		transaction.commit();
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Student> studentList = (List<Student>)session.createQuery("* from com.amsidh.model.Student").list();
		session.flush();
		transaction.commit();
		return studentList;
	}

	@Override
	public void updateStudent(Student student) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(student);
		session.flush();
		transaction.commit();
	}

}
