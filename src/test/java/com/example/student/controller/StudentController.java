package com.example.student.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.students.entity.Assignment;
import com.example.students.entity.Student;
import com.example.students.repository.StudentRepository;

@SpringBootTest
@WebMvcTest
public class StudentController {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	StudentRepository studentRepositoryMock;
	
	@Test
	public void getGradesForStudentWithOneAssignment() throws Exception {
		Assignment asg=new Assignment(1,"Assignment_1",85);
		List<Assignment> asgs=new ArrayList<>();
		asgs.add(asg);
		Student student=new Student();
		student.setRollNumber(1);
		student.setName("Sally");
		student.setAssignments(asgs);
		Mockito.doReturn(studentRepositoryMock.findByRollNumber(1)).doReturn(student);
		mockMvc.perform(MockMvcRequestBuilders.get("/student/grade/1")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
	}
	



}
