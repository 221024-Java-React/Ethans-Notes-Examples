package com.example.services;

import java.util.List;

import com.example.dao.CourseDao;
import com.example.dao.PersonDao;
import com.example.models.Course;
import com.example.utils.LoggingUtil;

public class CourseService {
	
	private CourseDao cDao;
	private PersonDao pDao;
	
	public CourseService(CourseDao cDao, PersonDao pDao) {
		this.cDao = cDao;
		this.pDao = pDao;
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
		LoggingUtil.getLogger().info("New course was created: " + c);
	}
	
	public void deleteCourse(int id) {
		cDao.deleteCourse(id);
		LoggingUtil.getLogger().info("Course was deleted: " + id);
	}
	
	public void updateCourse(Course c) {
		cDao.updateCourse(c);
		LoggingUtil.getLogger().info("Course was updated: " + c);
	}

}
