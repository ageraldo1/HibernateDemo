package com.itktechnologies.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentLoad {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			for ( int i = 0; i < 30; i++) {
				session.save(new Student("Student" + i, "Auto-generated", "student" + i + "@gsu.student.edu"));
			}
				
			session.getTransaction().commit();			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
		} finally {
			factory.close();
		}
	}
	

}
