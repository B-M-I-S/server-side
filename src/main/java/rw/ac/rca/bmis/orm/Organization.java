package rw.ac.rca.bmis.orm;


import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name= "organization")
public class Organization {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Set<Employee> employee;

    @OneToMany(mappedBy = "organization")
    private Set<Supplier> supplier;

    @OneToMany(mappedBy = "organization")
    private Set<Product>  products;

    private Date created_at;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;

    public int getEmployeesNumber() {
        return EmployeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        EmployeesNumber = employeesNumber;
    }

    private int EmployeesNumber;



    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    public Organization(Set<Employee> employee) {
        this.employee = employee;
    }

    public Organization() {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public Set<Supplier> getSupplier() {
        return supplier;
    }

    public void setSupplier(Set<Supplier> supplier) {
        this.supplier = supplier;
    }

    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }


    public Organization(String name, User owner, Date created_at, Address address){
        this.name =  name;
        this.owner =  owner;
        this.created_at = created_at;
        this.address = address;
    }


}