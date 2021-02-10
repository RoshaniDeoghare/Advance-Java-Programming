package in.edac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.entity.Employee;
import in.edac.entity.Student;

public class HelloHibernate {
	
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Student std = new Student();
		std.setName("Roshani");
		session.save(std);
		
		Employee e = new Employee();
		e.setDepartment("ECE");
		session.save(e);
		
		session.getTransaction().commit();
		session.close();
		
	}
}
