package rw.ac.rca.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import rw.ac.rca.bmis.orm.*;

import java.util.Date;


public class Main {

    public static void main(String[] args) {

        Address address= new Address("Kicukiro","Pobox 255","KK255");
        Organization organization=new Organization("Hirwa eddy","Ujeneza divine");
        Employee employee= new Employee("Josse MUHA",'F',organization);
//        Supplier supplier = new Supplier("Cynthia Umwari",organization);
        Product product = new Product("Computer machine","Dell");
        product.setDate(new Date());
        product.setOrganization(organization);


        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        @SuppressWarnings("deprecation")
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        System.out.println(" Beginning transaction...........");
        Transaction transaction=null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(address);
            session.saveOrUpdate(organization);
            session.saveOrUpdate(employee);
//            session.saveOrUpdate(supplier);
            session.saveOrUpdate(product);

            transaction.commit();

        }catch (Exception e){
            if (transaction!=null)transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }
}