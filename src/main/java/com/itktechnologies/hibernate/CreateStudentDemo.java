package com.itktechnologies.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itktechnologies.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student student = new Student("Alex", "Geraldo", "ageraldo1@gsu.student.edu");
			
			session.beginTransaction();
				session.save(student);
			session.getTransaction().commit();			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
		} finally {
			factory.close();
		}
		
		

	}

}
