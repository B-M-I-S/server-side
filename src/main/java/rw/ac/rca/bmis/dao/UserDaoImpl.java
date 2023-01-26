package rw.ac.rca.bmis.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import rw.ac.rca.bmis.orm.Address;
import rw.ac.rca.bmis.orm.User;
import rw.ac.rca.bmis.util.BmisSessionFactory;

import java.util.List;

@Repository
public class UserDaoImpl implements  UserDao{
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private BmisSessionFactory sf = new BmisSessionFactory();


    public void setSessionFactory(BmisSessionFactory sf){
    this.sf = sf;
    }


    @Override
    public void addUser(User user, Address address){
        Session session = BmisSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        user.setPassword(hashPassword(user.getPassword()));
        session.saveOrUpdate(address);
        session.saveOrUpdate(user);
        transaction.commit();
    }
    public void updateUser(User user){
        Session session = BmisSessionFactory.getSession();
        session.update(user);
        logger.info("Successfully updated user!!");
    }
    public void removeUser(int id){
        Session session = BmisSessionFactory.getSession();
        User u =  (User) session.load(User.class, id);

        if(null != u){
            session.delete(u);
            logger.info("User deleted successfully!!");

        }else{
            logger.info("User not found!");
        }
    }
    public User getUserById(int id){
        Session session = BmisSessionFactory.getSession();
        User u =  (User) session.load(User.class, id);

        if(u == null){
            logger.info("User not found!");
            return null;
        }
        return u;
    }

    public List<User> getUsers(){
       Session session =  BmisSessionFactory.getSession();
        List<User> usersList  = session.createQuery("from user").list();
        for(User u : usersList){
            logger.info("User List::"+u);
        }
        return usersList;
    }
    public static String hashPassword(String pw){
        return BCrypt.hashpw(pw, BCrypt.gensalt());
    };
}
