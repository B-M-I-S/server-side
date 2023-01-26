package rw.ac.rca.bmis.orm;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "user")
@Table
public class User extends  Person{
   public User(){
       super();
   }
   public  User(String name, String email, String phoneNumber, Date dob, String gender, String password){
       super(name, email, phoneNumber, dob,gender,password);
   }

}
