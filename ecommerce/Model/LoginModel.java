package tki.ecommerce.Model;

import tki.ecommerce.Controller.LoginController;
import tki.ecommerce.Controller.RegisterController;
import tki.ecommerce.DTO.LoginInfo;
import tki.ecommerce.DTO.UserInfo;
import tki.ecommerce.Repository.ActiveUser;
import tki.ecommerce.Repository.Logindb;

import java.util.List;

public class LoginModel {
    Logindb logindb= Logindb.getInstance();
    LoginController loginController;
    public  LoginModel(LoginController loginController)
    {
        this.loginController=loginController;
    }
    public void login(LoginInfo userInfo)
    {
       List<UserInfo> list= logindb. userInfoList;
        //System.out.println("list"+list);
        boolean isvalid=false;
       for(UserInfo user:list)
       {
           if(userInfo.name.equals(user.name)&&userInfo.password.equals(user.password)) {
               ActiveUser.getInstance(user);
               loginController.calldashboard();
               isvalid = true;
           }
           }
       if(!isvalid)
       loginController.calllogin();
    }
}
