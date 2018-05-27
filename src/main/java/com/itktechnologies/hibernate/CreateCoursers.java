package com.itktechnologies.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.itktechnologies.hibernate.entity.Course;
import com.itktechnologies.hibernate.entity.Instructor;
import com.itktechnologies.hibernate.entity.InstructorDetail;

public class CreateCoursers {
	
	public static void main (String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int instructorId = 1;

			session.beginTransaction();
			
				Instructor instructor = session.get(Instructor.class, instructorId);
				Course course1 = new Course("Java for experts");
				Course course2 = new Course("Linux for experts");
				
				instructor.addCourse(course1);
				instructor.addCourse(course2);
				
				session.save(course1);
				session.save(course2);
				
			session.getTransaction().commit();			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
			
		} finally {
			session.close();
			factory.close();
		}					
		
	}

}

