package com.example.models;

import java.time.LocalDateTime;
import java.util.Optional;

public class Assignment {
	
	private Student student;
	private String description;
	private LocalDateTime dueDate;
	private Optional<LocalDateTime> submittedDate;
	private Boolean graded;
	private Double grade;
	
	public Assignment(Student student, String description, LocalDateTime dueDate) {
		this.student = student;
		this.description = description;
		this.dueDate = dueDate;
		this.submittedDate = Optional.empty();
		this.graded = false;
		this.grade = 0.0;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public Optional<LocalDateTime> getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Optional<LocalDateTime> submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Boolean getGraded() {
		return graded;
	}

	public void setGraded(Boolean graded) {
		this.graded = graded;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Assignment [student=" + student + ", description=" + description + ", dueDate=" + dueDate
				+ ", submittedDate=" + submittedDate + ", graded=" + graded + ", grade=" + grade + "]";
	}
}
