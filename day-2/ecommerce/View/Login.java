package tki.ecommerce.View;

import tki.ecommerce.Controller.LoginController;
import tki.ecommerce.DTO.LoginInfo;

import java.util.Scanner;

public class Login {
    LoginController loginController;
    public Login()
    {
        loginController=new LoginController(this);
    }

    public void getInput() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Login view");
        System.out.println("enter the email");
        String email = sc.nextLine();
        System.out.println("enter password");
        String password = sc.nextLine();
        LoginInfo loginInfo=new LoginInfo(email,password);
        loginController.login(loginInfo);


    }
}
