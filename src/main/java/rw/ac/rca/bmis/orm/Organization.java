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

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;


    @OneToOne
    private Employee owner;

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

    public Employee getOwner() {
        return owner;
    }
    public void setOwner(Employee owner) {
        this.owner = owner;
    }


    public Organization(String name, Employee owner, Date created_at, Address address){
        this.name =  name;
        this.owner =  owner;
        this.created_at = created_at;
        this.address = address;
    }


}