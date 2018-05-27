package com.itktechnologies.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			
			int studentId=2;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
				System.out.println("Getting student with id : " + studentId);
				Student student = session.get(Student.class, studentId);
				System.out.println(student);
				
				// updating objects
				
				student.setFirstName("Scooby");
			session.getTransaction().commit();
			
			
			// bulk update
			
			session = factory.getCurrentSession();
			session.beginTransaction();
				session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
		} finally {
			factory.close();
		}
	}
	

}
