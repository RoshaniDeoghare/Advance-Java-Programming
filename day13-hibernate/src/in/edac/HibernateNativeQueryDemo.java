package in.edac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.entity.Student;

public class HibernateNativeQueryDemo {

public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
		//demo6();
		//demo7SingleRecord();
		//demo8SingleRecord();
	}
	
		
	
	public static void demo1() {
		Session session =  sessionFactory.openSession();
		
		String sql = "SELECT * FROM STUDENT";
		List<Student> list =  session.createNativeQuery(sql, Student.class).list();
		
		list.stream().map(Student::getName).forEach(System.out::println);
		
		session.close();
	}
	
	public static void demo2() {
		Session session =  sessionFactory.openSession();
		
		String sql = "SELECT * FROM STUDENT WHERE id=? AND name=?";
		List<Student> list =  session.createNativeQuery(sql, Student.class)
									.setParameter(1, 3)
									.setParameter(2, "Ovi")
									.list();
		
		list.stream().map(Student::getName).forEach(System.out::println);
		
		session.close();
	}

	public static void demo3() {
		Session session =  sessionFactory.openSession();
		
		String sql = "SELECT * FROM STUDENT WHERE id=:id AND name=:name";
		List<Student> list =  session.createNativeQuery(sql, Student.class)
									.setParameter("id", 4)
									.setParameter("name", "Yajat")
									.list();
		
		list.stream().map(Student::getName).forEach(System.out::println);
		
		session.close();
	}
	
	public static void demo4() {
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		
		String sql = "INSERT INTO STUDENT (name, email, mobile) VALUES (:name, :email, :mobile)";
		session.createNativeQuery(sql)
				.setParameter("name", "Roshani")
				.setParameter("email", "rosha@gmail.com")
				.setParameter("mobile", "9665149069")
				.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static void demo5() {
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		
		String sql = "UPDATE STUDENT SET name=:name WHERE id=:id";
		session.createNativeQuery(sql)
				.setParameter("name", "Mrunali")
				.setParameter("id", 1)
				.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static void demo6() {
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		
		String sql = "DELETE FROM STUDENT WHERE name=:name";
		session.createNativeQuery(sql)
				.setParameter("name", "")
				.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static void demo7SingleRecord() {
		Session session =  sessionFactory.openSession();
		
		String sql = "SELECT * FROM STUDENT WHERE id=:id";
		List<Student> list =  session.createNativeQuery(sql, Student.class)
									.setParameter("id", 1)
									.list();
		Student std = list.get(0);
		System.out.println(std);
		
		session.close();
	}
	

	public static void demo8SingleRecord() {
		Session session =  sessionFactory.openSession();
		
		String sql = "SELECT * FROM STUDENT WHERE id=:id";
		Student std =  session.createNativeQuery(sql, Student.class)
									.setParameter("id", 1)
									.getSingleResult();
		System.out.println(std);
		
		session.close();
	}
	
	
	
}
