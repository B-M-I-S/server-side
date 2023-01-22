package rca.ac.rw.bmis.orm;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

@Entity()
@Table(name = "Address")
public class Address extends User {
	private String name;
	private String streetAddress;
	private String postalCode;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "address")
	private Set<Supplier> suppliers;

	public Set<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Set<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	
	public Address(String name, String streetAddress, String postalCode) {
		this.name = name;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public Address(){}

}
