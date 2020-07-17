package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    	
    	Session session = sessionFactory.openSession();
    	
    	System.out.println("Session Factory: " + sessionFactory);
    	System.out.println("Session: " + session);
    }
}