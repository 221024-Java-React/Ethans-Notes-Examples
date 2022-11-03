package com.example.models;

public class Course {
	
	private int courseId;
	private String subject;
	private int courseNumber;
	private String courseName;
	private Person teacher;
	
	public Course() {
		super();
	}

	public Course(int courseId, String subject, int courseNumber, String courseName, Person teacher) {
		super();
		this.courseId = courseId;
		this.subject = subject;
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.teacher = teacher;
	}

	public Course(String subject, int courseNumber, String courseName) {
		super();
		this.subject = subject;
		this.courseNumber = courseNumber;
		this.courseName = courseName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Person getTeacher() {
		return teacher;
	}

	public void setTeacher(Person teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", subject=" + subject + ", courseNumber=" + courseNumber
				+ ", courseName=" + courseName + ", teacher=" + teacher + "]";
	}
	
}
