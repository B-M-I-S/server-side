package rw.ac.rca.bmis.orm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE )
    private int id;
    private String name;

    private String email;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    private String password;

    private Date dob;
    private String gender;

    public Person() {

    }

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person(String name, String email, String phoneNumber, Date dob, String gender, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.gender = gender;
        this.password =  password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
