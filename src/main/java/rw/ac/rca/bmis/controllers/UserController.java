package rw.ac.rca.bmis.controllers;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import rw.ac.rca.bmis.dao.GenericDao;
import rw.ac.rca.bmis.dao.UserDaoImpl;
import rw.ac.rca.bmis.orm.Address;
import rw.ac.rca.bmis.orm.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

@Controller
public class UserController {
    GenericDao<User> userDao = new GenericDao<>();
    GenericDao<Address> addressDao =  new GenericDao<>();

    UserDaoImpl  userDaoImpl =  new UserDaoImpl();
    public void saveUser() throws ParseException {
        User user = new User();
        SimpleDateFormat formatter2=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("=================WELCOME TO BMIS PLATFORM======================");
        System.out.print("Have an account? Enter 1 to Login \n No account? Enter 2 to Signup");
        Scanner scanner = new Scanner(System.in);
        int action= scanner.nextInt();
        scanner.nextLine();
        System.out.println(action);
        if(action == 2){
            System.out.println("Join our community!");
            System.out.println("Enter your fullname: ");
            user.setName(scanner.nextLine());
            System.out.println("Enter your email: ");
            user.setEmail(scanner.nextLine());
            System.out.println("Enter your DOB: ");
            user.setDob(formatter2.parse(scanner.nextLine()));
            System.out.println("Enter your address(format: (name,street,postalCode)): ");
            String[] add = scanner.nextLine().split(",");
            Address address = new Address(add[0], add[1], add[2]);
            user.setAddress(address);
            System.out.println("Enter your password: ");
            user.setPassword(scanner.nextLine());
            System.out.println("Enter your Phone number(+250...): ");
            user.setPhoneNumber(scanner.nextLine());
            System.out.println("Select your gender: ");
            user.setGender(scanner.nextLine());
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            this.addressDao.create(address);
           this.userDao.create(user);
            System.out.println("=================THANK YOU FOR JOINING OUR COMMUNITY=============");
        }else if(action == 1){
            System.out.println("=================LOGIN TO YOUR ACCOUNT==================");
            System.out.println("Enter your email: ");
            String email = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
            this.userDaoImpl.login(email, password);
        }

    }



}
