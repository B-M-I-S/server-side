package rw.ac.rca.bmis.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import rw.ac.rca.bmis.orm.Organization;
import rw.ac.rca.bmis.orm.User;
import rw.ac.rca.bmis.util.BmisSessionFactory;

import java.util.Scanner;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao{
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    private BmisSessionFactory sf = new BmisSessionFactory();

    public void setSessionFactory(BmisSessionFactory sf){
    this.sf = sf;
    }

    Scanner scanner = new Scanner(System.in);

    public static String hashPassword(String pw){
        return BCrypt.hashpw(pw, BCrypt.gensalt());
    };
    private boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword))
            return true;
        else
            return false;
    }

    public User login(String email, String password){
       Session session = BmisSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
       Query query  = session.createQuery("from user where email=:email");
       query.setParameter("email" , email);
        User user = (User) query.uniqueResult();
        if(this.checkPass(password, user.getPassword())){
            System.out.println("Login successfull!!");
            System.out.println("===========Welcome back , " + user.getName());
            System.out.println("SELECT ORGANIZATION");
            Set<Organization> organizations =  user.getOrganizations();
            for(Organization p : organizations){
                System.out.println("* " + p.getName());
            }
        }else{
            System.out.println("Credentials are invalid, try again!!");
        }
        return null;
    }

    public void dashboard(User user){
        System.out.println("SELECT YOUR ORGANIZATION");
        Set<Organization> organizations =  user.getOrganizations();
        for(Organization p : organizations) {
            System.out.println("* " + p.getName());
        }
        GenericDao<Organization >  organizationDao  =  new GenericDao<>();
    }


}
