package tki.ecommerce.Repository;

import tki.ecommerce.DTO.Products;
import tki.ecommerce.DTO.Tag;
import tki.ecommerce.DTO.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class ProductsDB {
    public static List<Products> productsList=new ArrayList<>();


    static ProductsDB productsDB;

    public static  ProductsDB getInstance()
    {
        if(productsDB==null)
        {
            productsDB=new ProductsDB();
            productsList.add(new Products(1,"tv","watch movies",12000, Tag.gadgets,2));
            productsList.add(new Products(2,"shirt","colorful",500, Tag.dress,3));
            productsList.add(new Products(3,"carrots","healthy",50, Tag.grocery,2));
            productsList.add(new Products(4,"potato","tasty",50, Tag.grocery,1));

        }
        return productsDB;
    }
}
