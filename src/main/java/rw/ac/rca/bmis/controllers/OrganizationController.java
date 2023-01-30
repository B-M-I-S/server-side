package rw.ac.rca.bmis.controllers;

import java.util.Scanner;

public class OrganizationController {
    private Scanner scanner =  new Scanner(System.in);
    public void createOrganization(){
        System.out.println("Please select what kind of organization: ");
        System.out.println("1. Business  2. Supplier");
        int category = scanner.nextInt();
        scanner.nextLine();
        if(category == 1){
            System.out.println("========ORGANISATION DATA===============");
            System.out.println("Name:.. ");
            int name = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Employees number : ");
        }
    }
}
