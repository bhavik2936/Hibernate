package com.driver;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.CourseBean;
import com.bean.FacultyBean;

public class OneToManyAndManyToOneDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		
		FacultyBean faculty = new FacultyBean();
		faculty.setFacultyName("John Doe");
		
		Set<CourseBean> courses = new HashSet<CourseBean>();
		CourseBean course1 = new CourseBean();
		course1.setCourseName("Java");
		CourseBean course2 = new CourseBean();
		course2.setCourseName("Android");
		CourseBean course3 = new CourseBean();
		course3.setCourseName("Hibernate");
		
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		faculty.setCourses(courses);

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		session.save(faculty);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
