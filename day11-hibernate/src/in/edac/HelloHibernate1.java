package in.edac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HelloHibernate1 {
	
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String args[]) {
		
		Session session = sessionFactory.openSession();
		
		System.out.println("Connection Check..!!");
		
		session.close();
	}

}
