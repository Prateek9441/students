package com.example.students.Factory;

import java.util.stream.Collectors;

public class Credit implements Type {

	static int creditScore = 0;

	@Override
	public String calculate(int value) {
		Integer sum = assignment.stream().collect(Collectors.summingInt(Integer::intValue));
		try {
			double ans = (double) sum / (100 * assignment.size());
			
			creditScore += 2;
			return "After Extra Credit Assignment is logged in the system:" + df2.format(ans * 100 + creditScore);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return null;
	}

}
