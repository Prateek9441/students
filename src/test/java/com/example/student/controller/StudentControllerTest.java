package com.example.student.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.students.StudentsApplication;
import com.example.students.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudentsApplication.class)
@AutoConfigureMockMvc
public class StudentControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
    @MockBean                           
    private StudentService studentService; 
	
    
	@Test
	public void getGradesForStudentWithOneAssignment() throws Exception {
		
		when(studentService.getResult("assignment", 85)).
		thenReturn("After Assignment #1 is logged in the system:85");
		
		MvcResult res= mvc.perform(get("/assignment/85")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
		
		String test1=res.getResponse().getContentAsString();
		
		assertEquals("After Assignment #1 is logged in the system:85%", test1);
			
	}
	
	@Test
	public void getGradesForStudentWithTwoAssignment() throws Exception {
		when(studentService.getResult("assignment", 85)).
		thenReturn("After Assignment #1 is logged in the system:85");
		when(studentService.getResult("assignment", 88)).
		thenReturn("After Assignment #2 is logged in the system:86.5");
		
		MvcResult res= mvc.perform(get("/assignment/88")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
		
		String test1=res.getResponse().getContentAsString();
			
		assertEquals("After Assignment #2 is logged in the system:86.5%", test1);	
	}

	@Test
	public void getGradesForStudentWithCredit() throws Exception {
		when(studentService.getResult("assignment", 85)).
		thenReturn("After Assignment #1 is logged in the system:85");
		when(studentService.getResult("assignment", 88)).
		thenReturn("After Assignment #2 is logged in the system:86.5");
		when(studentService.getResult("credit", 0)).
		thenReturn("After Extra Credit Assignment is logged in the system:88.5");
		
		String test=studentService.getResult("credit", 0);
		
		assertEquals("After Extra Credit Assignment is logged in the system:88.5", test);	
	}
	
}
