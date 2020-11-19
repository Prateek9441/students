package com.example.student.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.students.service.StudentService;

@SpringBootTest(classes=StudentController.class)
@EnableAutoConfiguration
//@RunWith(SpringRunner.class)
public class StudentController {
	
	
	@Autowired                           
    private MockMvc mockMvc;  
                                                 
    @MockBean                           
    private StudentService studentService; 
	
	@Test
	public void getGradesForStudentWithOneAssignment() throws Exception {

		//given(studentService.getResult("assignment", 85));
		mockMvc.perform(MockMvcRequestBuilders.get("/assignment/85")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
		
	}
	



}
