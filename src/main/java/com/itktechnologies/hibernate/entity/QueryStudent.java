package com.itktechnologies.hibernate.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudent {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student").getResultList();
			
			for ( int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i));
			}
			
			students = session.createQuery("from Student where lastName='Geraldo'").getResultList();
			for ( int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i));
			}
			
			students = session.createQuery("from Student where email LIKE '%gsu%'").getResultList();
			for ( int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i));
			}
			

			session.getTransaction().commit();			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
		} finally {
			factory.close();
		}
	}	

}
