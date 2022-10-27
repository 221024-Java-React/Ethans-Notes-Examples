package com.example.casting;

import com.example.subjects.Subject;
import com.example.subjects.Math;
import com.example.subjects.Reading;

public class SubjectFactory {
	
	//A good example of casting is with a Factory class pattern
	//Factory pattern is used to generate objects who's type is not known until runttime
	//In our case we can make a factory object which creates Subject objects, and assign the type of subject
	//at runtime
	
	public static Subject createSubject(String name) {
		switch(name) {
			case "MATH":
				return new Math();
			default:
				return new Reading();
		}
	}

}
