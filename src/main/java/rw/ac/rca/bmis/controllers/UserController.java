package rw.ac.rca.bmis.controllers;
import org.springframework.stereotype.Controller;
import rw.ac.rca.bmis.dao.UserDaoImpl;
import rw.ac.rca.bmis.orm.Address;
import rw.ac.rca.bmis.orm.User;
import rw.ac.rca.bmis.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

@Controller
public class UserController {
    private UserService userService;

    public void setUserService(UserService us){
        this.userService = us;
    }

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
            System.out.println("Enter your fullname: ");
            user.setName(scanner.nextLine());
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
            UserDaoImpl userServices = new UserDaoImpl();
            userServices.addUser(user, address);

            System.out.println("=================THANK YOU FOR JOINING OUR COMMUNITY=============");
        }else if(action == 1){
            System.out.println("=================LOGIN TO YOUR ACCOUNT==================");
            System.out.println("Enter your email: ");
            String email = scanner.nextLine();
            String password = scanner.nextLine();

        }

    }

}
