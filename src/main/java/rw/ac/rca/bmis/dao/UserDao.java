package rw.ac.rca.bmis.dao;

import org.mindrot.jbcrypt.BCrypt;
import rw.ac.rca.bmis.orm.Address;
import rw.ac.rca.bmis.orm.User;

import java.util.List;

public interface UserDao {

    void addUser(User user, Address address);

    public void updateUser(User user);

    public List<User> getUsers();

    public User getUserById(int id);

    public void removeUser(int id);



}


