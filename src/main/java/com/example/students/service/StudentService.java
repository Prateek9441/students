package com.example.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.students.entity.Assignment;
import com.example.students.entity.Exam;
import com.example.students.entity.ExtraCredit;
import com.example.students.entity.Student;
import com.example.students.model.RequestObject;
import com.example.students.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return (List<Student>)this.studentRepository.findAll();
	}

	public Student findByRollNumber(int rollNo) {
		return this.studentRepository.findByRollNumber(rollNo);
	}
	
	public double getGradesForStudent(int rollNo) {
		Student student=this.studentRepository.findByRollNumber(rollNo);
		int assignmentSum=0,examSum=0;
		double asgGrade=0.0,examGrade=0.0,grade=0.0;
		
		for(int i=0;i<student.getAssignments().size();i++) {
			assignmentSum=assignmentSum+student.getAssignments().get(i).getMarks();			
		}
		
		asgGrade=assignmentSum/(100*student.getAssignments().size());
		asgGrade=asgGrade+(2*student.getExtraCreditScore().size());
		
		for(int i=0;i<student.getExams().size();i++) {
			examSum=examSum+ student.getExams().get(i).getMarks();
		}
		
		examGrade=examSum/(100*student.getExams().size());
		grade=(asgGrade*.101)+(examGrade*.899);
		return grade<100?grade:100;
	}
	
	public Student createStudent(Student studentObject) {
		return this.studentRepository.save(studentObject);
	}
	
	public void updateStudentRecord(String type,int rollNo,List<RequestObject> requestObj) {
		Student student=this.studentRepository.findByRollNumber(rollNo);
		if("Assignment".equalsIgnoreCase(type)) {
			List<Assignment> assignments=student.getAssignments();
			requestObj.forEach( obj ->{
				assignments.add(new Assignment(rollNo,obj.getName(),obj.getValue()));
				student.setAssignments(assignments);
			});
		}else if("Exam".equalsIgnoreCase(type)){
			List<Exam> exams=student.getExams();
			requestObj.forEach( obj ->{
				exams.add(new Exam(rollNo,obj.getName(),obj.getValue()));
				student.setExams(exams);
			});
		}else {
			List<ExtraCredit> credits=student.getExtraCreditScore();
			requestObj.forEach( obj ->{
				credits.add(new ExtraCredit(rollNo,obj.getName(),obj.getValue()));
				student.setExtraCreditScore(credits);
			});
		}
		this.studentRepository.save(student);
	}
	
}
