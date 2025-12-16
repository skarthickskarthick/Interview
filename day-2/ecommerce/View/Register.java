package tki.ecommerce.View;

import tki.ecommerce.Controller.RegisterController;
import tki.ecommerce.DTO.Address;
import tki.ecommerce.DTO.UserInfo;
import tki.ecommerce.POJO.AddressPojo;
import tki.ecommerce.POJO.UserPojo;

import java.util.Scanner;

public class Register {
    RegisterController registerController;
    Register()
    {
        registerController=new RegisterController(this);
    }
    public void getInput() throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Register yourself!");
        System.out.println("enter the name");
        String name=sc.nextLine();
        System.out.println("enter email");
        String email=sc.nextLine();
        System.out.println("enter password");
        String password=sc.nextLine();
        System.out.println("enter phone");
        String phone=sc.nextLine();
        System.out.println("enter the doorno");
        String doorno=sc.nextLine();
        System.out.println("enter streetname");
        String streetname=sc.nextLine();
        System.out.println("enter locality");
        String locality=sc.nextLine();
        AddressPojo address=new AddressPojo(doorno,streetname,locality);
        UserPojo userInfo=new UserPojo(name,email,password,phone);
        registerController.register(userInfo,address);

    }
}
