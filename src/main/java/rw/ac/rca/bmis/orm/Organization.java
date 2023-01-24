package rw.ac.rca.bmis.orm;


import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name= "organization")
public class Organization {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Set<Employee> employee;

    @OneToMany(mappedBy = "organization")
    private Set<Supplier> supplier;

    private String owner;

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

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Organization(String name,String owner) {
        this.name = name;
        this.owner = owner;

    }


}