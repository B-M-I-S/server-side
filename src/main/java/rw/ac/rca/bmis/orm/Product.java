package rw.ac.rca.bmis.orm;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="product")
public class Product {

    private String productName;
    private String brand;


    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @ManyToOne()
    @JoinColumn(name = "organizationId")
    private Organization organization;

    @Id
    @GeneratedValue
    private Long id;

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



    public Product(String productName, String brand) {
        this.productName = productName;
        this.brand = brand;
    }


}