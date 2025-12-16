package tki.ecommerce.Model;

import tki.ecommerce.Controller.RegisterController;
import tki.ecommerce.DTO.UserInfo;
import tki.ecommerce.POJO.AddressPojo;
import tki.ecommerce.POJO.UserPojo;
import tki.ecommerce.Repository.DBUtil;
import tki.ecommerce.Repository.Logindb;

public class RegisterModel {
    Logindb logindb= Logindb.getInstance();
    RegisterController registerController;
  public  RegisterModel(RegisterController registerController)
    {
        this.registerController=registerController;
    }
 public boolean register(UserPojo userPojo, AddressPojo addressPojo) throws Exception {
     if(userPojo.getName()==null||userPojo.getEmail()==null||userPojo.getPassword()==null||userPojo.getPhone()==null||addressPojo==null)
         return false;

//    logindb. userInfoList.add(userInfo);
     DBUtil dbUtil=new DBUtil();
     dbUtil.insertUser(userPojo, addressPojo);
    return  true;
 }

}
