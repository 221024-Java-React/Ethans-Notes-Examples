package com.example.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Course;
import com.example.models.Person;

@Repository
@Transactional
public class CourseDaoORM implements CourseDao{

	private SessionFactory sessionFactory;
	
	@Autowired
	public CourseDaoORM(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	@Override
	public List<Course> readAllCourses() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Course", Course.class).list();
	}

	@Override
	public void createCourse(Course c) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(c);
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		
		Course c = sessionFactory.getCurrentSession().get(Course.class, id);
		
		sessionFactory.getCurrentSession().delete(c);
	}

	@Override
	public void updateCourse(Course c) {
		Person teacher = sessionFactory.getCurrentSession().get(Person.class, c.getTeacher().getId());
		c.setTeacher(teacher);
		sessionFactory.getCurrentSession().update(c);
		
	}

}
