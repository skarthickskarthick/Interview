package tki.ecommerce.Controller;

import tki.ecommerce.DTO.Tag;
import tki.ecommerce.Model.DashboardModel;
import tki.ecommerce.Model.LoginModel;
import tki.ecommerce.View.Dashboard;
import tki.ecommerce.View.Login;

public class DashboardController {
    DashboardModel dashboardModel;
    Dashboard dashboard;
    public DashboardController(Dashboard dashboard)
    {
        dashboardModel=new DashboardModel(this);
        this.dashboard=dashboard;

    }
    public void viewProducts()
    {
        dashboardModel.viewProducts();
//        dashboard.viewOptions();

    }
    public void viewProductsByTag(Tag tag)
    {
        dashboardModel.viewProductsByTag(tag);
    }
    public boolean order(int productid,int quantity)
    {
        return dashboardModel.order(productid,quantity);
    }
    public void viewInvoice()
    {
        dashboardModel.getInvoice();
    }
    public boolean addToCart(int productid,int quantity)
    {
        return dashboardModel.addToCart(productid,quantity);
    }

    public void viewCart()
    {
        dashboardModel.getCartItems();
    }
}
