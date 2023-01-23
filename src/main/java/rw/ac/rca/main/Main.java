package rw.ac.rca.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {

    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        @SuppressWarnings("deprecation")
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        System.out.println(" Beginning transaction...........");
        Transaction transaction=null;
        try {
            transaction = session.beginTransaction();
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