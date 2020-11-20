package com.example.students.Factory;

import java.util.stream.Collectors;

public class Exam implements Type {

	@Override
	public String calculate(int value) {
		try {
			Integer assignmentSum = assignment.stream().collect(Collectors.summingInt(Integer::intValue));
			double ans = (double) assignmentSum / (100 * assignment.size()) + (double) Credit.creditScore / 100;
			exam.add(value);
			Integer examSum = exam.stream().collect(Collectors.summingInt(Integer::intValue));

			double examVal = (double) examSum / (100 * exam.size());

			return "After Exam #" + exam.size() + " is logged in the system:"
					+ df2.format((ans * .101 + examVal * .899) * 100);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return null;
	}

}
