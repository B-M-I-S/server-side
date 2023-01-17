package rca.ac.rw.bmis.starter;

import java.lang.module.Configuration;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import antlr.collections.List;
import javassist.expr.NewArray;
import rw.ac.rca.smis.orm.Address;
import rw.ac.rca.smis.orm.Course;
import rw.ac.rca.smis.orm.Instructor;
import rw.ac.rca.smis.orm.Mark;
import rw.ac.rca.smis.orm.Student;

public class Starter {
	public static void main(String[] args) {
		try {
			
		Address add1 = new Address("Rwanda", "Nyabihu", "POBOX014");
		Course course1 = new Course("Chemistry");
		Student std1 = new Student("Alice", java.sql.Date.valueOf("2022-04-22") , 'F');
		
		
		Mark mark1 = new Mark(20.2);
		
		mark1.setStudent(std1);
		mark1.setCourse(course1);
		
		
		Instructor inst1 = new Instructor("Aphrorwa", java.sql.Date.valueOf("2022-06-22") , 'F');
		
		std1.setAddress(add1);
		inst1.setAddress(add1);
		
		
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		configuration.configure("hibernate.cfg.xml");
		System.out.println("Opening the session....");
		
		
		
		SessionFactory factory =  configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		System.out.println("Beginning transactions");
		
		org.hibernate.Transaction transaction =  session.beginTransaction();
		
		System.out.println("Beginning transaction");
		System.out.println(add1);

		session.saveOrUpdate(add1);
		
		session.saveOrUpdate(course1);
		session.saveOrUpdate(std1);
		session.saveOrUpdate(mark1);
		System.out.println("Saved..");
		
		transaction.commit();
		session.close();
		factory.close();
		
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		
	}
}