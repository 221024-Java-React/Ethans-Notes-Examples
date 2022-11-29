package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Course;
import com.example.services.CourseService;
import com.example.services.PersonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/course")
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class CourseController {
	
	private CourseService courseService;
	
	// /course (get)
	@GetMapping("/")
	private List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	
	// /course?id=number
	@GetMapping()
	private Course returnCourseById(@RequestParam("id")int id) {
		return courseService.getCourseById(id);
	}
	
	
	// /course (post)
	@PostMapping("/")
	private String createCourse(@RequestBody Course c) {
		courseService.createCourse(c);
		return "Course created";
	}
	
	
	// /course (put)
	@PutMapping("/")
	private Course updateCourse(@RequestBody Course c) {
		courseService.updateCourse(c);
		return courseService.getCourseById(c.getCourseId());
	}

}
