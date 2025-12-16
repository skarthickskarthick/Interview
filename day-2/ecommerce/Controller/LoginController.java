package tki.ecommerce.Controller;

import tki.ecommerce.DTO.LoginInfo;
import tki.ecommerce.DTO.UserInfo;
import tki.ecommerce.Model.LoginModel;
import tki.ecommerce.Model.RegisterModel;
import tki.ecommerce.View.Dashboard;
import tki.ecommerce.View.Login;
import tki.ecommerce.View.Register;

public class LoginController {
    LoginModel loginModel;
    Login login;
    public LoginController(Login login)
    {
        loginModel=new LoginModel(this);
        this.login=login;

    }
    public void login(LoginInfo loginInfo) throws Exception {
        loginModel.login(loginInfo);


    }
    public void calllogin() throws Exception {
        Login loginView=new Login();
        loginView.getInput();
    }
    public void calldashboard() throws Exception {
        Dashboard dashboard=new Dashboard();
        dashboard.viewOptions();
    }

}
