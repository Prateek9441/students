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
public class Assignment {

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="rollNumber")
	private int rollNo;
	
	@Id
	private String name;
	private int marks;
	
	public Assignment(int rollNo,String name,int marks) {
		this.rollNo=rollNo;
		this.name=name;
		this.marks=marks;
	}
}
