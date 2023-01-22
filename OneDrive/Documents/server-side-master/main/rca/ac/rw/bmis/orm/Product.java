package rca.ac.rw.bmis.orm;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="product")
public class Product extends User implements  Serializable{

    private String productName;
    private String brand;

    @ManyToMany(mappedBy = "products")
    private Set<Supplier> suppliers;

    public Product(){};

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
       this.brand = brand;
    }



    public Set<Supplier> getSuppliers() {return suppliers;}

    public void setSuppliers(Set<Supplier> suppliers) {this.suppliers = suppliers;}


    public Product(String productName, String brand) {
        this.productName = productName;
        this.brand = brand;
    }
}
