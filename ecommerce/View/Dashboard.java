package tki.ecommerce.View;

import tki.ecommerce.Controller.DashboardController;
import tki.ecommerce.Controller.LoginController;
import tki.ecommerce.DTO.Tag;

import java.util.Scanner;

public class Dashboard {
    DashboardController dashboardController;
    public Dashboard()
    {
        dashboardController=new DashboardController(this);
    }
   public void viewOptions() {
       Scanner sc = new Scanner(System.in);

       while (true) {
           System.out.println("------Dashboard------");
           System.out.println("1.view products 2.view by tags 3.place order 4.view invoice 5.add to cart 6.view cart items 7.exit");
           int option = sc.nextInt();
           if (option == 1) {
               dashboardController.viewProducts();
           } else if (option == 2) {
               System.out.println("1.gadgets 2.dress 3.grocery");
               int n = sc.nextInt();
               Tag tag = null;
               if (n == 1)
                   tag = Tag.gadgets;
               else if (n == 2)
                   tag = Tag.dress;
               else if (n == 3)
                   tag = Tag.grocery;
               else {
                   System.out.println("invalid choice");

               }
               dashboardController.viewProductsByTag(tag);
           } else if (option == 3) {
               dashboardController.viewProducts();
               System.out.println("enter the product id");
               int productid= sc.nextInt();
               System.out.println("enter the quantity");
               int n= sc.nextInt();
               if(!dashboardController.order(productid,n))
                   System.out.println("cannot place order");



           } else if (option==4) {
               dashboardController.viewInvoice();

           } else if (option==5) {
               dashboardController.viewProducts();
               System.out.println("enter the product id");
               int productid= sc.nextInt();
               System.out.println("enter the quantity");
               int n= sc.nextInt();
              if(!dashboardController.addToCart(productid,n))
                  System.out.println("cannot add to cart");
           } else if (option==6) {
               dashboardController.viewCart();

           } else if (option == 7) {
               System.out.println("thank you");
               break;
           } else {
               System.out.println("invalid option try again!");

           }

       }
   }
}
