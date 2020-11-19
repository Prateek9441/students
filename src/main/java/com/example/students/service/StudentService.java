package com.example.students.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private ArrayList<Integer> assignment = new ArrayList<Integer>();
	private ArrayList<Integer> exam = new ArrayList<Integer>();
	private DecimalFormat df2 = new DecimalFormat("#.##");
	private int creditScore = 0;

	public String getResult(String type, int value) {
		
		if ("assignment".equalsIgnoreCase(type)) {

			assignment.add(value);
			Integer sum = assignment.stream().collect(Collectors.summingInt(Integer::intValue));
			double ans = (double) sum / (100 * assignment.size());
			return df2.format(ans * 100 + creditScore);

		} else if ("credit".equalsIgnoreCase(type)) {
			Integer sum = assignment.stream().collect(Collectors.summingInt(Integer::intValue));
			double ans = (double) sum / (100 * assignment.size());
			creditScore += 2;
			return df2.format(ans * 100 + creditScore);

		} else {

			Integer assignmentSum = assignment.stream().collect(Collectors.summingInt(Integer::intValue));
			double ans = (double) assignmentSum / (100 * assignment.size()) + (double) creditScore / 100;
			exam.add(value);
			Integer examSum = exam.stream().collect(Collectors.summingInt(Integer::intValue));

			double examVal = (double) examSum / (100 * exam.size());

			return df2.format((ans * .101 + examVal * .899) * 100);

		}

	}

}
