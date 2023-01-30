package rw.ac.rca.bmis.orm;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity(name = "user")
@Table
public class User extends  Person{
   public User(){
       super();
   }

    public String getCategory() {
        return category;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private Set<Organization> organizations;

    public void setCategory(String category) {
        this.category = category;
    }

    private String category;
   public  User(String name, String email, String phoneNumber, Date dob, String gender, String password, String category){
       super(name, email, phoneNumber, dob,gender,password);
       this.category = category;
   }

}
