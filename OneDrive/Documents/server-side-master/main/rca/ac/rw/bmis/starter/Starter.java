package rca.ac.rw.bmis.starter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import rca.ac.rw.bmis.orm.*;

public class Starter {

	public static void main(String[] args){

		Address myAddress=new Address("Rwanda","Westernn","223-000-334");
		Organization organization = new Organization("High_Ltd","Rukundo Honore");
		Employee employee = new Employee("Hirwa Eddy",'M',organization);
		Supplier supplier =new Supplier("second_Tech",myAddress,organization);
		Product product = new Product("Computer","Mac");


		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		System.out.println("Beginning transactions ....");
		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(myAddress);
		session.saveOrUpdate(organization);
		session.saveOrUpdate(employee);
		session.saveOrUpdate(supplier);
		session.saveOrUpdate(product);

		transaction.commit();
		session.close();
		factory.close();

	}
}