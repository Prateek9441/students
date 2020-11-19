package com.example.students.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Student {
	
	@Id
	private int rollNumber;
	private String name;
	
	@OneToMany
	private List<Assignment> assignments;
	
	@OneToMany
	private List<Exam> exams;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rollNo", cascade = CascadeType.ALL, orphanRemoval = true )
	private List<ExtraCredit> extraCreditScore;
	
}
