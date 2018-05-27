package com.itktechnologies.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;


import com.itktechnologies.hibernate.entity.Instructor;
import com.itktechnologies.hibernate.entity.InstructorDetail;

public class DeleteInstructorsTester {
	
	public static void main (String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int instructorId = 4;
			
			session.beginTransaction();
			
				Instructor instructor = session.get(Instructor.class, instructorId);
				
				if ( instructor != null ) {				
					session.delete(instructor);  // delete cascade Instructor & InstructorDetail objects due to @OneToOne(cascade=CascadeType.ALL)
				}
				
			session.getTransaction().commit();			
						
		} catch (Exception ex) {
			ex.printStackTrace();
			
			
		} finally {
			factory.close();
		}		
	}
}
