package com.itktechnologies.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;


import com.itktechnologies.hibernate.entity.Instructor;
import com.itktechnologies.hibernate.entity.InstructorDetail;

public class AddInstructorsTester {
	
	public static void main (String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Instructor instructor = new Instructor("Alex", "Geraldo", "alexandre_geraldo@hotmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com", "work");
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
				session.save(instructor);  // saving Instructor & InstructorDetail objects due to @OneToOne(cascade=CascadeType.ALL)
			session.getTransaction().commit();			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
			
		} finally {
			factory.close();
		}					
		
	}

}
