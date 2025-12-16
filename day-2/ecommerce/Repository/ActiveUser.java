package tki.ecommerce.Repository;

import tki.ecommerce.DTO.UserInfo;
import tki.ecommerce.POJO.UserPojo;

import java.util.ArrayList;
import java.util.List;

public class ActiveUser {
    public static UserPojo user;
    static ActiveUser activeUser;

    public static  ActiveUser getInstance(UserPojo users)
    {
        if(activeUser==null)
        {
            activeUser=new ActiveUser();
            user=users;
        }
        return activeUser;
    }
}
