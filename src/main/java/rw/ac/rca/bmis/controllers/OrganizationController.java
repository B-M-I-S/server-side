package rw.ac.rca.bmis.controllers;
import rw.ac.rca.bmis.dao.GenericDao;
import rw.ac.rca.bmis.orm.Address;
import rw.ac.rca.bmis.orm.Organization;
import rw.ac.rca.bmis.orm.User;

import java.util.Scanner;
public class OrganizationController {
    GenericDao<Address> addressDao =  new GenericDao<>();
    GenericDao<Organization> organizationDao =  new GenericDao<>();

     Scanner scanner =  new Scanner(System.in);
    public void createOrganization(User user){
        System.out.println("Register your organization!!");
        System.out.println("Please select what kind of organization: ");
        System.out.println("1. Business  2. Supplier");
        int category = scanner.nextInt();
        scanner.nextLine();
            Organization organization = new Organization();
            System.out.println("========ORGANISATION DATA===============");
            System.out.println("Name:.. ");
            organization.setName(scanner.nextLine());
            scanner.nextLine();
            System.out.println("Employees number : ");
            organization.setEmployeesNumber(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Address : ");
            System.out.println("Enter your address(format: (name,street,postalCode)): ");
            String[] add = scanner.nextLine().split(",");
            Address address = new Address(add[0], add[1], add[2]);
            organization.setAddress(address);
            organization.setOwner(user);
            addressDao.create(address);
            organizationDao.create(organization);
    }
}
