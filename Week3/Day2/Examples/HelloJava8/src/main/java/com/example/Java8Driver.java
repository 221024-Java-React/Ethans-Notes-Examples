package com.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.lambdas.MyFunctionalInterface;
import com.example.models.Assignment;
import com.example.models.Student;

public class Java8Driver {
	
	//Lets create some lambdas
	public static Student makeStudentFunction(String first, String last) {
		
		//We will use the functional interface inside of our method
		MyFunctionalInterface<Student> s = () -> {
			//The logic inside of these parethesis is the logic provided to the one method of the
			//functional interface
			
			Random rand = new Random();
			//Create a random 4 digit number as an id
			String id = String.format("%04d", rand.nextInt(10000));
			String username = first + last + id;
			String email = first + "." + last + id +  "@school.edu";
			return new Student(first, last, username, email, "p@ssword", true);

		};
		
		return s.execute();
		
	}
	
	public static Assignment makeAssignmentFunction(Student s, String description, String due) {
		MyFunctionalInterface<Assignment> a = () -> {
			//We can use a date and time formatter to take in a string date and convert to the a java date
			DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			return new Assignment(s, description, LocalDateTime.parse(due, formatDate));
		};
		
		return a.execute();
	}
	
	public static void main(String[] args) {
		
		Student s1 = makeStudentFunction("Ethan", "McGill");
		Student s2 = makeStudentFunction("Hans", "Alafriz");
		s2.setPassword("resetPassword");
		Student s3 = makeStudentFunction("Mark", "Satin");
		Student s4 = makeStudentFunction("Adrian", "Caso");
		s4.setPassword("differentPassword");
		Student s5 = makeStudentFunction("Joshua", "Maciel");
		
		List<Student> students = List.of(s1,s2,s3,s4,s5);
		System.out.println(students);
		
		//For each loop example with lambdas
		//For each student in the list, do some logic on each student
		students.forEach((student) -> {
			if(student.getPassword().equals("p@ssword")) {
				System.out.println(student.getFirstName() + " " + student.getLastName() + " needs to reset their password");
			}
		});
		
		
		List<Assignment> assignmentList = new ArrayList<>();
		
		//For each student, create 4 assignments with due Dates
		students.forEach((student) -> {
				assignmentList.add(makeAssignmentFunction(student, "Adding", "2022-11-30 17:00"));
				assignmentList.add(makeAssignmentFunction(student, "Subtraction", "2022-12-30 17:00"));
				assignmentList.add(makeAssignmentFunction(student, "Multiplication", "2023-01-30 17:00"));
				assignmentList.add(makeAssignmentFunction(student, "Division", "2023-02-30 17:00"));
		});
		
		assignmentList.forEach((assignment) -> System.out.println(assignment));
		
		//Basic streams
		List<Assignment> s1Assignments = assignmentList.stream()
				//Filter out certain data, and return what matches
				.filter(assignment -> assignment.getStudent().equals(s1))
				.collect(Collectors.toList());
		
		System.out.println("Assignments that belong to student 1: ");
		System.out.println(s1Assignments);
		
		//Lets transform some of Ethans Assignments with streams
		s1Assignments = s1Assignments.stream()
				.map(assignment -> {
					
					//We have some logic to transform our data, then we need to return after transforming
					//each peice
					if(assignment.getDescription().equals("Adding")) {
						assignment.setSubmittedDate(Optional.of(LocalDateTime.of(2022, 11, 8, 15, 30)));
						assignment.setGraded(true);
						assignment.setGrade(95.0);
					}
					
					if(assignment.getDescription().equals("Subtraction")) {
						assignment.setSubmittedDate(Optional.of(LocalDateTime.of(2022, 12, 30, 17, 05)));
						assignment.setGraded(true);
						assignment.setGrade(65.0);
					}
					
					if(assignment.getDescription().equals("Multiplication")) {
						assignment.setSubmittedDate(Optional.of(LocalDateTime.of(2022, 1, 15, 17, 00)));
						assignment.setGraded(true);
						assignment.setGrade(75.0);
					}
					
					//The map needs to return the transformed data
					return assignment;
					
				})
				.collect(Collectors.toList());
		
		System.out.println(s1Assignments);
		
		//We want to return all of student ones assignments that are both graded, and turned in on time
		List<Assignment> onTimeAssignments = s1Assignments.stream()
				.filter(assignment -> assignment.getSubmittedDate().isPresent())
				.filter(assignment -> assignment.getSubmittedDate().get().isBefore(assignment.getDueDate()))
				.collect(Collectors.toList());
		
		System.out.println(onTimeAssignments);
		
		//We can even reduce an entire collection of data down to a single number
		Double s1AverageGrade = s1Assignments.stream()
				.filter(assignment -> assignment.getGraded())
				.mapToDouble(assignment -> assignment.getGrade())
				.average()
				.getAsDouble();
		
		System.out.println("Student one average grade: " + s1AverageGrade);
		
	}

}
