package com.itktechnologies.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			
			Student student = new Student("Student-Read", "Auto-generated", "student-read@gsu.student.edu");
			int studentId;
			
			
			session.beginTransaction();
				session.save(student);				
			session.getTransaction().commit();
			
			studentId = student.getId();
			
			System.out.println("Saved student. Generated id :" + studentId);
			
			//
			session = factory.getCurrentSession();
			session.beginTransaction();
				System.out.println("Getting student with id : " + studentId);
				Student retStudent = session.get(Student.class, studentId);
				System.out.println(retStudent);
			session.getTransaction().commit();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
		} finally {
			factory.close();
		}
	}
	

}
