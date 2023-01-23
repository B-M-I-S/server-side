package rw.ac.rca.bmis.orm;

import javax.persistence.*;


@Entity()
@Table(name="employee")
public class Employee extends Person {

    @ManyToOne
    @JoinColumn(name="organizationId", nullable = false)
    private Organization organization;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    private int salary;



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