package in.edac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HelloHibernate1 {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {
		readAll();
	}
	
	
	public static void readAll() {
		Session session = sessionFactory.openSession();
		
		// HQL
		List<Student> list = session.createQuery("FROM Student", Student.class).list();
		System.out.println(list);
		
		session.close();
	}
	
	
	public static void readSinglDemo() {
		Session session = sessionFactory.openSession();
		
		Student std =  session.find(Student.class, 4);
		System.out.println(std);
		
		session.close();
	}
	
	
	public static void deleteDemo() {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		
		Student std = new Student();
		std.setId(1);
				
		session.delete(std);
		
		tx.commit();
		session.close();
	}
	
	public static void updateDemo() {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		
		Student std = new Student();
		std.setId(1);
		std.setEmail("cdac@gmail.com");
		std.setMobile("121212121");
		std.setUsername("CDAC");
		std.setPassword("asdfadsf");
		
		session.update(std);
		
		tx.commit();
		session.close();
	}
	
	
	public static void createDemo() {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		
		
		Student std = new Student();
		std.setUsername("CDAC INDIA");
		std.setPassword("eNdIa");
		
		// saving the state using hibernate
		session.save(std);
		
		tx.commit();
		session.close();
	}
	
	
}