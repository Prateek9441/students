package com.example.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.students.entity.Student;
import com.example.students.model.RequestObject;
import com.example.students.service.StudentService;

@RestController("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/fetchAll")
	public List<Student> getAllStudents(){
		return this.studentService.getAllStudents();
	}
	
	@GetMapping("/{rollNo}")
	public Student getStudent(@PathVariable int rollNo) {
		return this.studentService.findByRollNumber(rollNo);
	}
	
	@GetMapping("/grade/{rollNo}")
	public double getGradesForStudent(@PathVariable int rollNo) {
		return this.studentService.getGradesForStudent(rollNo);
		
	}
	
	@PostMapping
	public boolean createStudent(@RequestBody Student studentObject) {
		try {
		this.studentService.createStudent(studentObject);
		return true;
		}catch(Exception exception) {
			return false;
		}
	}
	
	@PutMapping("/{type}/{id}")
	public void updateRecordForStudent(@PathVariable String type,@PathVariable int id,@RequestBody List<RequestObject> requestObj) {
		this.studentService.updateStudentRecord(type,id,requestObj);
	}
	
}
