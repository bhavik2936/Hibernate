package com.driver;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.AddressBean;
import com.bean.CustomerBean;

public class OneToOneDemonstrate {

	// returns single user
	CustomerBean GenerateUser() {
		CustomerBean customer = new CustomerBean();
		customer.setCustomerName("John Doe");
		
		AddressBean address = new AddressBean();
		address.setStreetName("11, Park Avenue");
		address.setCity("New York City");
		address.setState("New York");
		
		customer.setAddress(address);
		return customer;
	}
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction transaction = null;

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

//		session.persist(new OneToOneDemonstrate().GenerateUser());
		
		TypedQuery<CustomerBean> query = session.createQuery("FROM CustomerBean c", CustomerBean.class);
		List<CustomerBean> customerList = query.getResultList();

		for (CustomerBean c : customerList) {
			System.out.println("Customer => " + c.getCustomerId() + " | " + c.getCustomerName());
			AddressBean a = c.getAddress();
			System.out.println("Address => " + a.getAddressId() + " | " + a.getStreetName() + " | " + a.getCity() + " | " + a.getState());
		}
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
