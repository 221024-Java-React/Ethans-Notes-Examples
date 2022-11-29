package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.CourseDao;
import com.example.repository.PersonDao;
import com.example.models.Course;

@Service
public class CourseService {
	
	private CourseDao cDao;
	private PersonDao pDao;
	
	@Autowired
	public CourseService(CourseDao cDao, PersonDao pDao) {
		this.cDao = cDao;
		this.pDao = pDao;
	}
	
	//No arg used for setter injection
	public CourseService () {
		
	}
	
	public List<Course> getAllCourses() {
		
		List<Course> cList = cDao.readAllCourses();
		
		for(int i=0; i<cList.size(); i++) {
			Course c = cList.get(i);
			if(c.getTeacher() != null) {
				c.setTeacher(pDao.getPersonById(c.getTeacher().getId()));
				cList.set(i, c);
			}
		}
		
		return cList;
	}
	
	public void createCourse(Course c) {
		cDao.createCourse(c);
	}
	
	public void deleteCourse(int id) {
		cDao.deleteCourse(id);
	}
	
	public void updateCourse(Course c) {
		cDao.updateCourse(c);
	}
	
	public Course getCourseById(int id) {
		List<Course> courses = cDao.readAllCourses();
		for(Course c: courses) {
			if(c.getCourseId() == id) {
				return c;
			}
		}
		
		return null;
	}
	
	public void setCDao (CourseDao cDao) {
		this.cDao = cDao;
	}
	
	public void setPDao (PersonDao pDao) {
		this.pDao = pDao;
	}

}
