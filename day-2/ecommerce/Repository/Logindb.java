package tki.ecommerce.Repository;

import tki.ecommerce.DTO.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class Logindb {
    public static List<UserInfo> userInfoList;
    static Logindb logindb;

    public static  Logindb getInstance()
    {
        if(logindb==null)
        {
            logindb=new Logindb();
            userInfoList=new ArrayList<>();
        }
        return logindb;
    }
}
