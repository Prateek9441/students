package com.example.students.Factory;

import java.text.DecimalFormat;
import java.util.ArrayList;

public interface Type {

	ArrayList<Integer> assignment = new ArrayList<Integer>();
	 ArrayList<Integer> exam = new ArrayList<Integer>();
	DecimalFormat df2 = new DecimalFormat("#.##");
	
	String calculate(int value);
	
}
