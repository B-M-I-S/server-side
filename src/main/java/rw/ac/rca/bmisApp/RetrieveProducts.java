package rw.ac.rca.bmisApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import rw.ac.rca.bmis.orm.Product;

public class RetrieveProducts {
    public static void main(String[] args) {

            //method baces is an  error so it implemented

                Configuration config=new Configuration();
                config.configure("hibernate.cfg.xml");
                SessionFactory factory=config.buildSessionFactory();
                Session session=factory.openSession();

                System.out.println("Fetching object using get:");
                Product p = (Product) session.get(Product.class,2);

                System.out.println("brand:"+p.getBrand());
                System.out.println("Name:"+p.getProductName());



                session.close();
                factory.close();
            }
}
