package com.example.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.students.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/{type}/{marks}")
	public String updateRecordForStudent(@PathVariable String type,@PathVariable int marks) {
		return this.studentService.getResult(type,marks)+"%";
	}
	
}
