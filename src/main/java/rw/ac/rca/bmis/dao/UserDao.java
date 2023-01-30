package rw.ac.rca.bmis.dao;

import org.mindrot.jbcrypt.BCrypt;
import rw.ac.rca.bmis.orm.Address;
import rw.ac.rca.bmis.orm.User;

import java.util.List;

public interface UserDao {

    public User login(String email, String password);

}


