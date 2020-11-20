package com.example.student.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.students.StudentsApplication;
import com.example.students.service.StudentService;

//@SpringBootTest(classes=StudentController.class)
//@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudentsApplication.class)
@WebAppConfiguration
public class StudentController {
	
	
	                           
    private MockMvc mockMvc;  
                                                 
    @MockBean                           
    private StudentService studentService; 
	
    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    protected void setUp() {
    	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
	@Test
	public void getGradesForStudentWithOneAssignment() throws Exception {
		when(studentService.getResult("assignment", 85)).
		thenReturn("After Assignment #1 is logged in the system:85%");
		
		String test=studentService.getResult("assignment", 85);
		
		assertEquals("After Assignment #1 is logged in the system:85%", test);
		
	}
	
	@Test
	public void getGradesForStudentWithTwoAssignment() throws Exception {
		when(studentService.getResult("assignment", 85)).
		thenReturn("85%");
		when(studentService.getResult("assignment", 88)).
		thenReturn("After Assignment #2 is logged in the system:86.5%");
		
		String test=studentService.getResult("assignment", 88);
		
		assertEquals("After Assignment #2 is logged in the system:86.5%", test);	
	}

	@Test
	public void getGradesForStudentWithCredit() throws Exception {
		when(studentService.getResult("assignment", 85)).
		thenReturn("85%");
		when(studentService.getResult("assignment", 88)).
		thenReturn("86.5%");
		when(studentService.getResult("credit", 0)).
		thenReturn("After Extra Credit Assignment is logged in the system:88.5%");
		String test=studentService.getResult("credit", 0);
		
		assertEquals("After Extra Credit Assignment is logged in the system:88.5%", test);	
	}
	
}
