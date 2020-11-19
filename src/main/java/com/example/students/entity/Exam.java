package com.example.students.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Exam {
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="rollNumber")
	private int rollNo;
	
	@Id
	private String name;
	private int marks;

	public Exam(int rollNo,String name,int marks) {
		this.rollNo=rollNo;
		this.name=name;
		this.marks=marks;
	}
}
