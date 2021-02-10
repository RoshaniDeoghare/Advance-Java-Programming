package in.edac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.entity.Employee;
import in.edac.entity.Student;

public class HelloHibernate {
	
public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		addStudent();
		addEmployee();
		
	}
	
	public static void addStudent() {
		
Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Student std1 = new Student( "Mrunal","mrunal26@gmail.com","8180076526");
		Student std2 = new Student( "Monika","monika@gmail.com","708657436");
		Student std3 = new Student( "Bhushan","bhushan12@gmail.com","9011428242");
		Student std4 = new Student( "Aishwarya","aish25@gmail.com","9876543226");
		Student std5 = new Student( "Amol","amol@gmail.com","8234567096");
		Student std6 = new Student( "Manish","manish@gmail.com","8425367890");
		
		session.save(std1);
		session.save(std2);
		session.save(std3);
		session.save(std4);
		session.save(std5);
		session.save(std6);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	public static void addEmployee() {
		
Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Employee std1 = new Employee("cse", "google", "Rupali");
		Employee std2 = new Employee("it", "whatsapp", "Ruchit");
		Employee std3 = new Employee("ece", "tesla", "Roshani");
		Employee std4 = new Employee("ee", "electric car", "Rushikesh");
		Employee std5 = new Employee("me", "tesla adv", "Rushabh");
		Employee std6 = new Employee("civil", "hyperloop", "Rohit");

		session.save(std1);
		session.save(std2);
		session.save(std3);
		session.save(std4);
		session.save(std5);
		session.save(std6);

		
		session.getTransaction().commit();
		session.close();
		
	}
}
