package     rca.ac.rw.bmis.orm;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="supplier")
public class Supplier extends User implements Serializable {

    @ManyToOne
    @JoinColumn(name ="address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name="organization_id")
    private Organization organization;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Supplier", joinColumns = { @JoinColumn(name = "supplier_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
    private Set<Product> products;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Set<Product> getProducts() {return products;}

    public void setProducts(Set<Product> products) {this.products = products;}


    public Supplier(){}


    public Supplier(String name, Address address, Organization organization){
        this.setName(name);
        this.address=address;
        this.organization = organization;

    }


}
