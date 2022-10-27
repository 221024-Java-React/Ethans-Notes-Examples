package com.example.subjects;

public class Math extends Subject{
	
	private static String name = "MATH";
	private String equation;
	
	public Math() {
		this.equation = "1 + 1";
	}
	
	//With covariance we can change the Object return type of the Subject Abstract class to String
	@Override
	public String teachSubject() {
		// TODO Auto-generated method stub
		return "1 + 1 = 2";
	}

	//With covariance we can change the protected modifer of the getName() class to public
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setEquation(String equation) {
		this.equation = equation;
	}
	
	public String getEquation() {
		return this.equation;
	}

}
