package rw.ac.rca.bmis.orm;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

public class Person implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE )
    private int id;
    private String name;

    private String email;
    private String phoneNumber;


    private Date dob;
    private char gender;



    public Person() {

    }

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
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public Person(String name, Date dob, char gender) {
        super();
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }



}
