package tki.ecommerce.Model;

import tki.ecommerce.Controller.RegisterController;
import tki.ecommerce.DTO.UserInfo;
import tki.ecommerce.Repository.Logindb;

public class RegisterModel {
    Logindb logindb= Logindb.getInstance();
    RegisterController registerController;
  public  RegisterModel(RegisterController registerController)
    {
        this.registerController=registerController;
    }
 public boolean register(UserInfo userInfo)
 {
     if(userInfo.name==null||userInfo.address==null||userInfo.password==null)
         return false;

    logindb. userInfoList.add(userInfo);
    return  true;
 }

}
