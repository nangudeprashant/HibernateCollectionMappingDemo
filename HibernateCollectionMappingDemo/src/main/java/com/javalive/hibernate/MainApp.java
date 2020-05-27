package com.javalive.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javalive.entity.Address;
import com.javalive.entity.UserDetails;

public class MainApp {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();//Create user object
		user.setUserName("First Last"); //Set user name

		Address address1 = new Address(); // create first embedded object address
		address1.setStreet("First Street");
		address1.setCity("First City");
		address1.setState("First State");
		address1.setPincode("First Pin");

		Address address2 = new Address(); // create second embedded object address
		address2.setStreet("Second Street");
		address2.setCity("Second City");
		address2.setState("Second State");
		address2.setPincode("Second Pin");
		//adding addresses object to the list of address
		user.getLisOfAddresses().add(address1);
		user.getLisOfAddresses().add(address2);
		
		
		try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession(); //create session object from the session factory
		session.beginTransaction(); //initialize the transaction object from session
		session.save(user); // save the user
		session.getTransaction().commit(); //commit the transaction
		session.close(); //closing session
		}
		catch(HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			HibernateUtil.shutdown();
		}
	}
}
