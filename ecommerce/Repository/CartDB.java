package tki.ecommerce.Repository;

import tki.ecommerce.DTO.Cart;
import tki.ecommerce.DTO.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class CartDB {
    public static List<Cart> cartList;
    static CartDB cartDB;

    public static  CartDB getInstance()
    {
        if(cartDB==null)
        {
            cartDB=new CartDB();
            cartList=new ArrayList<>();
        }
        return cartDB;
    }
}
