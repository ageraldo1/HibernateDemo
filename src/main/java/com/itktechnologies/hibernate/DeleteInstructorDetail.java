package com.itktechnologies.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;


import com.itktechnologies.hibernate.entity.Instructor;
import com.itktechnologies.hibernate.entity.InstructorDetail;

public class DeleteInstructorDetail {
	
	public static void main (String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int instructorDetailId = 5;
			
			session.beginTransaction();
			
				InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
				
				if ( instructorDetail != null ) {
					instructorDetail.getInstructor().setInstructorDetail(null); // break the bi-directional link
					session.delete(instructorDetail); 
				}
				
			session.getTransaction().commit();			
						
		} catch (Exception ex) {
			ex.printStackTrace();			
			
		} finally {
			session.close();
			factory.close();
		}		
	}
}
