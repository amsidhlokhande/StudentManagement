package com.amsidh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amsidh.model.Student;
import com.amsidh.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/index")
	public String welComePage(Map<String, Object> map) {
		map.put("student", new Student());
		map.put("studentList", studentService.getAllStudents());
		return "student";
	}

	@RequestMapping(value = "/action.do", method = RequestMethod.POST)
	public String doActions(@ModelAttribute Student student,
			BindingResult result, @RequestParam(value="myAction") String action,
			Map<String, Object> map) throws Exception{
		Student studentResult = new Student();
		
		if (action.toLowerCase().equals("add")) {
			studentService.addStrudent(student);
			studentResult = student;
		}

		if (action.toLowerCase().equals("delete")) {
			studentService.deleteStudent(student);
			studentResult = student;
		}

		if (action.toLowerCase().equals("update")) {
			studentService.updateStudent(student);
			studentResult = new Student();
		}

		if (action.toLowerCase().equals("search")) {
			Student searchedStudent = studentService
					.getStudent(student.getId());
			studentResult = searchedStudent != null ? searchedStudent
					: new Student();
		}

		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudents());

		return "student";
	}

}
