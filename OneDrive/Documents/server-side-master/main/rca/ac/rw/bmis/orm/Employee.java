package rca.ac.rw.bmis.orm;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class Employee extends User implements Serializable {


    @ManyToOne
    @JoinColumn(name="organization_id", nullable=false)
    private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Employee(){}

    public Employee(String name, char gender, Organization organization) {

        this.setName(name);
        this.setGender(gender);
        this.organization = organization;
    }
}
