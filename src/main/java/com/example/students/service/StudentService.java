package com.example.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.students.Factory.Type;
import com.example.students.Factory.TypeFactory;

@Service
public class StudentService {

	@Autowired
	TypeFactory getType;

	/**
	 * Factory Method implementation.
	 */

	public String getResult(String type, int value) {
		
		Type myType = getType.getShape(type);

		if (myType != null) {
			return myType.calculate(value);
		}

		return "No type selected:0";

	}

}
