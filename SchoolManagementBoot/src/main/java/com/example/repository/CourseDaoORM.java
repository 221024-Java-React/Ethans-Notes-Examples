package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.example.models.Course;
import com.example.models.Person;
import com.example.util.HibernateConfig;

@Repository
public class CourseDaoORM implements CourseDao{

	
	@Override
	public List<Course> readAllCourses() {
		// TODO Auto-generated method stub
		Session ses = HibernateConfig.getSession();
		
		
		return ses.createQuery("from Course", Course.class).list();
	}

	@Override
	public void createCourse(Course c) {
		// TODO Auto-generated method stub
		
		Session ses = HibernateConfig.getSession();
		Transaction t = ses.beginTransaction();
		
		ses.save(c);
		
		t.commit();
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		
		Session ses = HibernateConfig.getSession();
		
		Course c = ses.get(Course.class, id);
		
		Transaction t = ses.beginTransaction();
		ses.delete(c);
		t.commit();
	}

	@Override
	public void updateCourse(Course c) {
		Session ses = HibernateConfig.getSession();
		Person teacher = ses.get(Person.class, c.getTeacher().getId());
		c.setTeacher(teacher);
		
		Transaction t = ses.beginTransaction();
		
		ses.update(c);
		
		t.commit();
		
	}

}
