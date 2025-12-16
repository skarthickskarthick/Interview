package tki.ecommerce.Model;

import tki.ecommerce.Controller.DashboardController;
import tki.ecommerce.Controller.LoginController;
import tki.ecommerce.DTO.*;
import tki.ecommerce.POJO.Payment;
import tki.ecommerce.POJO.ProductPojo;
import tki.ecommerce.POJO.UserPojo;
import tki.ecommerce.Repository.*;

import java.util.List;
import java.util.Scanner;

public class DashboardModel {
    ProductsDB productsDB= ProductsDB.getInstance();
    DashboardController dashboardController;
    DBUtil dbUtil;
    public  DashboardModel(DashboardController dashboardController)
    {
        this.dashboardController=dashboardController;
        dbUtil=new DBUtil();
    }

    public void viewProducts() throws Exception {

        List<ProductPojo> list=  dbUtil.getAllProducts1();
        for(ProductPojo products:list)
        {
            System.out.println(products.toString());
        }

    }
    public void viewProductsByTag(String name ) throws Exception {
        List<ProductPojo> list= dbUtil.getProductsByCategory(name);;
        for(ProductPojo products:list)
        {
            System.out.println(products.toString());
        }
    }
    public boolean order(int productid,int quantity) throws Exception {
//        if(!isPresent(productid,quantity))
//            return false;
//        updateQuantity(productid);
//        UserInfo user=ActiveUser.getInstance(null).user;
//        Products products=getProduct(productid);
//
//        float total=getTotal(productid,quantity);
//        Invoice invoice=new Invoice(user,products,total,quantity);
//        InvoiceDB.getInstance().invoiceList.add(invoice);
//        //getInvoice();
//
//        return true;
        ProductPojo productPojo=dbUtil.getByProductid(productid);
        if(quantity<=0||productPojo==null||productPojo.getQuantity()<quantity)
            return false;

        Payment payment=new Payment();
        payment.setMode("upi");
        UserPojo userPojo=ActiveUser.getInstance(new UserPojo()).user;

        payment.setUserPojo(userPojo);

        float total=getTotal(productid,quantity);
        payment.setAmount(total);
        System.out.println(payment.getUserPojo().getUserid());
       int payid= dbUtil.makePayment(payment);
       dbUtil.updateQuantity(productid,quantity);
       dbUtil.generateInvoice(payment,productPojo,quantity,payid);

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
    public  float getTotal(int productid,int quantity) throws Exception {
        return getPrice(productid)*quantity;
    }
    public float getPrice(int productid) throws Exception {
        ProductPojo productPojo=dbUtil.getByProductid(productid);
        return productPojo.getPrice();
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
//        if(!isPresent(productid,quantity))
//            return false;
//
//        UserInfo user=ActiveUser.getInstance(null).user;
//        Products products=getProduct(productid);
//        //isalready carted
//
//        Cart cart=new Cart(user,products,quantity);
//        CartDB.getInstance().cartList.add(cart);
//        //getCartItems();

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
