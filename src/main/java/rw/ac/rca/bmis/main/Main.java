package rw.ac.rca.bmis.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import rw.ac.rca.bmis.controllers.OrganizationController;
import rw.ac.rca.bmis.controllers.UserController;
import rw.ac.rca.bmis.orm.Address;


public class Main {

    public static void main(String[] args) {
        try {
            UserController uc = new UserController();
            uc.saveUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}