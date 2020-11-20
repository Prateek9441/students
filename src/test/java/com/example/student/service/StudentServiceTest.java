package com.example.student.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.students.StudentsApplication;
import com.example.students.Factory.Assignment;
import com.example.students.Factory.TypeFactory;
import com.example.students.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudentsApplication.class)
@AutoConfigureMockMvc
public class StudentServiceTest {
	
	
    @Autowired                           
    private StudentService studentService; 
	
    @MockBean                           
    private TypeFactory getType; 
	
	@Test
	public void getGradesForStudentWithOneAssignment() throws Exception {
		
		when(getType.getShape("assignment")).
		thenReturn(new Assignment());
		
		String res=studentService.getResult("assignment", 85);
		
		
		assertEquals("After Assignment #1 is logged in the system:85", res);
		
		
	}
	
	
	
}
