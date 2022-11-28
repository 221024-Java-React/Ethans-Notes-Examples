package com.example.controllers;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.models.Course;
import com.example.services.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Handler;

@Component("CourseControllerBean")
public class CourseController {
	
	private CourseService cServ;
	private ObjectMapper om;
	
	@Autowired
	public CourseController(CourseService cServ) {
		this.cServ = cServ;
		om = new ObjectMapper();
	}
	
	//No args for setter injection
	public CourseController () {
		this.om = new ObjectMapper();
	}
	
	public Handler handleCreate = (context) -> {
		
		Course c = om.readValue(context.body(), Course.class);
		
		cServ.createCourse(c);
		
		context.status(201);
		context.result("New course created");
	};
	
	public Handler handleRead = (context) -> {
		context.status(200);
		context.result(om.writeValueAsString(cServ.getAllCourses()));
	};
	
	public Handler handleUpdate = (context) -> {
		Course c = om.readValue(context.body(), Course.class);
		
		cServ.updateCourse(c);
		
		context.status(200);
		context.result("Course was updated");
	};
	
	public Handler handleDelete = (context) -> {
		LinkedHashMap<String, Integer> body = om.readValue(context.body(), LinkedHashMap.class);
		
		cServ.deleteCourse(body.get("courseId"));
		
		context.status(200);
		context.result("Course was removed");
	};

	
	public void setCServ(CourseService cServ) {
		this.cServ = cServ;
	}
	
}
