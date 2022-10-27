package com.example.subjects;

public class Reading extends Subject{
	
	private static String name = "READING";
	private String book;
	private int chapter;
	
	public Reading() {
		this.book = "O'Reilly Learning Java An Introduction to Real-World Programming with Java";
		this.chapter = 1;
	}

	@Override
	public String teachSubject() {
		// TODO Auto-generated method stub
		return "Read chapter " + this.chapter;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setBook(String book) {
		this.book = book;
	}
	
	public String getBook() {
		return this.book;
	}
	
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}
	
	public int getChapter() {
		return this.chapter;
	}

}
