package tki.ecommerce.Repository;

import tki.ecommerce.DTO.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class ActiveUser {
    public static UserInfo user;
    static ActiveUser activeUser;

    public static  ActiveUser getInstance(UserInfo users)
    {
        if(activeUser==null)
        {
            activeUser=new ActiveUser();
            user=users;
        }
        return activeUser;
    }
}
