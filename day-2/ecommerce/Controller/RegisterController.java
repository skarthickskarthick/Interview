package tki.ecommerce.Controller;

import tki.ecommerce.DTO.UserInfo;
import tki.ecommerce.Model.RegisterModel;
import tki.ecommerce.POJO.AddressPojo;
import tki.ecommerce.POJO.UserPojo;
import tki.ecommerce.Repository.Logindb;
import tki.ecommerce.View.Login;
import tki.ecommerce.View.Register;

public class RegisterController {
    RegisterModel registerModel;
    Register register;
    public RegisterController(Register register)
    {
        registerModel=new RegisterModel(this);
        this.register=register;

    }
    public void register(UserPojo userPojo,AddressPojo addressPojo) throws Exception {
        if(registerModel.register(userPojo, addressPojo))
            calllogin();
        else
            register.getInput();

    }
    public void calllogin() throws Exception {
        Login loginView=new Login();
        loginView.getInput();
    }
}
