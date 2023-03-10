package rw.ac.rca.bmis.orm;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="supplier")
public class Supplier extends Person {

    @ManyToOne
    @JoinColumn(name = "organizationId")
    private Organization organization;

    @Id
    @GeneratedValue
    private Long id;


    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }



    public Supplier() {
        super();
    }


    public Supplier(String name, Address address, Organization organization) {
        super();
        this.setName(name);
        this.organization = organization;
    }

}