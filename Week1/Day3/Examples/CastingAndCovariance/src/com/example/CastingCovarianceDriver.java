package com.example;

import com.example.casting.SubjectFactory;
import com.example.subjects.Math;
import com.example.subjects.Subject;

public class CastingCovarianceDriver {

	public static void main(String[] args) {
		String subject;
		
		subject = "MATH";
		
		Subject m1 = SubjectFactory.createSubject(subject);
		
		System.out.println(m1.teachSubject());
		//The get name method is not available to us
		//System.out.println(m1.getName());
		//Lets fix that with casting
		Math m2 = (Math) m1;
		System.out.println(m2.getName());
		System.out.println(m2.getEquation());
		//The above will obviously not work if we attempted to cast a Reading object from a Math object
		

	}

}
