package com.example.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="course_id")
	private int courseId;
	
	@Column(name="course_subject")
	private String subject;
	
	@Column(name="course_number")
	private int courseNumber;
	
	@Column(name="course_name")
	private String courseName;
	
	//One teacher can teach many courses, we need to use a mapping for this
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="teacher_id")
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
