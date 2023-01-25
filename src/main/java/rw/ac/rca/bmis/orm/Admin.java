package rw.ac.rca.bmis.orm;

import javax.persistence.OneToOne;

public class Admin extends Person{
    @OneToOne()
    private Organization organization;


}
