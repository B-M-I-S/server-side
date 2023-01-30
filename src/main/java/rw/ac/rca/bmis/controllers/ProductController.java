package rw.ac.rca.bmis.controllers;
import rw.ac.rca.bmis.dao.GenericDao;
import rw.ac.rca.bmis.orm.Organization;
import rw.ac.rca.bmis.orm.Product;

import java.util.Scanner;

public class ProductController {
    GenericDao<Product> productDao=  new GenericDao<>();
    Scanner scanner = new Scanner(System.in);
    public void createProduct(Organization organization){
        Product product =  new Product();
        System.out.println("==============Register product=============");
        System.out.println("PRODUCT DATA: ");
        System.out.print("Name : .. ");
        product.setProductName(scanner.nextLine());
        System.out.println("Brand:..");
        product.setBrand(scanner.nextLine());
        product.setOrganization(organization);
    }

    public void retrieveProduct(){
        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();

        System.out.println("enter productID: ");
        System.out.println("Fetching products ----------");

        Product p =productDao.get(num);

        System.out.println("brand:"+p.getBrand());
        System.out.println("Name:"+p.getProductName());
    }
}
