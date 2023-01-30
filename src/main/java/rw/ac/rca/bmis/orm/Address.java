package rw.ac.rca.bmis.orm;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity()
@Table(name = "address")
public class Address {
    private String name;
    private String streetAddress;
    private String postalCode;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "address")
    private Set<User> users;
    @Id
    @GeneratedValue()
    private Long id;



    public Address(String name, String streetAddress, String postalCode) {
        super();
        this.name = name;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public Address(){}


}