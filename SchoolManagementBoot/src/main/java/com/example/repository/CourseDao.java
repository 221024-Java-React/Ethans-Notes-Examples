package com.example.repository;

import java.util.List;

import com.example.models.Course;

public interface CourseDao {
	
	public List<Course> readAllCourses();
	public void createCourse(Course c);
	public void deleteCourse(int id);
	public void updateCourse(Course c);

}
