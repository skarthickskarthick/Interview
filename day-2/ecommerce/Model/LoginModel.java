package tki.ecommerce.Model;

import tki.ecommerce.Controller.LoginController;
import tki.ecommerce.Controller.RegisterController;
import tki.ecommerce.DTO.LoginInfo;
import tki.ecommerce.DTO.UserInfo;
import tki.ecommerce.POJO.UserPojo;
import tki.ecommerce.Repository.ActiveUser;
import tki.ecommerce.Repository.DBUtil;
import tki.ecommerce.Repository.Logindb;

import java.util.List;

public class LoginModel {
    Logindb logindb= Logindb.getInstance();
    LoginController loginController;
    public  LoginModel(LoginController loginController)
    {
        this.loginController=loginController;
    }
    public void login(LoginInfo loginInfo) throws Exception {

       DBUtil dbUtil=new DBUtil();
        UserPojo userPojo=dbUtil.getUser(loginInfo);
       if(userPojo==null)
       {
           loginController.calllogin();
       }
       else
       {
           ActiveUser.getInstance(userPojo);
           loginController.calldashboard();
       }
    }
}
