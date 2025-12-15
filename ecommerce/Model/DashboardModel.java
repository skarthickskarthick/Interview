package tki.ecommerce.Model;

import tki.ecommerce.Controller.DashboardController;
import tki.ecommerce.Controller.LoginController;
import tki.ecommerce.DTO.*;
import tki.ecommerce.Repository.*;

import java.util.List;
public class DashboardModel {
    ProductsDB productsDB= ProductsDB.getInstance();
    DashboardController dashboardController;
    public  DashboardModel(DashboardController dashboardController)
    {
        this.dashboardController=dashboardController;
    }

    public void viewProducts()
    {

        List<Products> list= productsDB. productsList;
        for(Products products:list)
        {
            System.out.println(products.toString());
        }
    }
    public void viewProductsByTag(Tag tag)
    {
        List<Products> list= productsDB. productsList;
        for(Products products:list)
        {
            if(products.tag==tag)
            System.out.println(products.toString());
        }
    }
    public boolean order(int productid,int quantity)
    {
        if(!isPresent(productid,quantity))
            return false;
        updateQuantity(productid);
        UserInfo user=ActiveUser.getInstance(null).user;
        Products products=getProduct(productid);

        float total=getTotal(productid,quantity);
        Invoice invoice=new Invoice(user,products,total,quantity);
        InvoiceDB.getInstance().invoiceList.add(invoice);
        //getInvoice();

        return true;
    }
    public boolean isPresent(int productid,int quantity)
    {
        List<Products> list= productsDB. productsList;
        for(Products products:list)
        {
            if(products.productid==productid&&products.quantity>=quantity)
               return true;
        }
        return false;
    }
    public void  updateQuantity(int productid)
    {
        List<Products> list= productsDB. productsList;
        for(Products products:list)
        {
            if(products.productid==productid)
            {
                products.quantity-=1;
                return;
            }
        }

    }
    public Products getProduct(int productid)
    {
        List<Products> list= productsDB. productsList;
        for(Products products:list)
        {
            if(products.productid==productid)
            {

                return products;
            }
        }
        return null;
    }
    public  float getTotal(int productid,int quantity)
    {
        return getPrice(productid)*quantity;
    }
    public float getPrice(int productid)
    {
        List<Products> list= productsDB. productsList;
        for(Products products:list)
        {
            if(products.productid==productid)
            {

                return products.price;
            }
        }
        return 0;
    }

    public void getInvoice()
    {
        List<Invoice> list= InvoiceDB. invoiceList;
       // System.out.println("invoice manually");
        if(list==null)
            return;
        for(Invoice invoice:list)
        {
            System.out.println(invoice.toString());
        }
    }

    public boolean addToCart(int productid,int quantity)
    {
        if(!isPresent(productid,quantity))
            return false;

        UserInfo user=ActiveUser.getInstance(null).user;
        Products products=getProduct(productid);
        //isalready carted

        Cart cart=new Cart(user,products,quantity);
        CartDB.getInstance().cartList.add(cart);
        //getCartItems();

        return true;
    }
    public void getCartItems()
    {

        List<Cart> list= CartDB.cartList;
        if(list==null)
            return;
        //System.out.println("cart manually");
        for(Cart cart:list)
        {
            System.out.println(cart.toString());
        }
    }

}
