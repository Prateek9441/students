package com.example.students.Factory;

import java.util.stream.Collectors;

public class Assignment implements Type {

	@Override
	public String calculate(int value) {
		assignment.add(value);
		try {
			Integer sum = assignment.stream().collect(Collectors.summingInt(Integer::intValue));
			double ans = (double) sum / (100 * assignment.size());
			
			return "After Assignment #" + assignment.size() + " is logged in the system:"
					+ df2.format(ans * 100 + Credit.creditScore);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
