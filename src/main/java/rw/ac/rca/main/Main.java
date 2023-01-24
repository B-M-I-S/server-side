package rw.ac.rca.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import rw.ac.rca.bmis.orm.*;

public class Main {

    public static void main(String[] args) {

        Address myAddress=new Address("Rwanda","Westernn","Nyabihu");
        Organization organization = new Organization("high tech","Hirwa eddy");
        Supplier supplier = new Supplier("Josse Mukamana",myAddress,organization);
        Product   product = new Product("Computer machine","Mac");
        Employee employee = new Employee("Cynthia Umwari",'F',organization);





        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        @SuppressWarnings("deprecation")
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        System.out.println(" Beginning transaction...........");


        Transaction transaction=null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(myAddress);
            session.saveOrUpdate(organization);
            session.saveOrUpdate(supplier);
            session.saveOrUpdate(product);
            session.saveOrUpdate(employee);

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