package com.itktechnologies.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			
			int studentId=38;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
				System.out.println("Getting student with id : " + studentId);
				Student student = session.get(Student.class, studentId);
				System.out.println(student);
				
				session.delete(student);				
			session.getTransaction().commit();
			
			// using queries			
			session = factory.getCurrentSession();
			session.beginTransaction();
				session.createQuery("delete from Student where id=36").executeUpdate();
			session.getTransaction().commit();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
		} finally {
			factory.close();
		}
	}
	

}
