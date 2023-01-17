package rca.ac.rw.bmis.orm;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "organizations")
public class Organization implements Serializable{
	private String name;
	private Employee employee;
	private String description;
	private Number employeesNumber;
	private String owner;
	private Date createad_at;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Number getEmployeesNumber() {
		return employeesNumber;
	}
	public void setEmployeesNumber(Number employeesNumber) {
		this.employeesNumber = employeesNumber;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getCreatead_at() {
		return createad_at;
	}
	public void setCreatead_at(Date createad_at) {
		this.createad_at = createad_at;
	}
	public Organization(String name, Employee employee, String description, Number employeesNumber, String owner,
			Date createad_at) {
		super();
		this.name = name;
		this.employee = employee;
		this.description = description;
		this.employeesNumber = employeesNumber;
		this.owner = owner;
		this.createad_at = createad_at;
	}
	
	
}
