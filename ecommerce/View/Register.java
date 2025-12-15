package tki.ecommerce.View;

import tki.ecommerce.Controller.RegisterController;
import tki.ecommerce.DTO.Address;
import tki.ecommerce.DTO.UserInfo;

import java.util.Scanner;

public class Register {
    RegisterController registerController;
    Register()
    {
        registerController=new RegisterController(this);
    }
    public void getInput()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Register yourself!");
        System.out.println("enter the name");
        String name=sc.nextLine();
        System.out.println("enter password");
        String password=sc.nextLine();
        System.out.println("enter the doorno");
        String doorno=sc.nextLine();
        System.out.println("enter locality");
        String locality=sc.nextLine();
        Address address=new Address(doorno,locality);
        UserInfo userInfo=new UserInfo(name,password,address);
        registerController.register(userInfo);

    }
}
