package tki.ecommerce.View;

import tki.ecommerce.Controller.DashboardController;
import tki.ecommerce.Model.DashboardModel;
import tki.ecommerce.POJO.ProductPojo;
import tki.ecommerce.Repository.DBUtil;

import java.util.List;

public class MainEntry {
    static String version="1.0.0";
    public static void main(String[] args) throws Exception {
        MainEntry mainEntry=new MainEntry();
        mainEntry.init();
    }
    public void init() throws Exception {
        System.out.println("welcome to e-commerce website");
        System.out.println("version : "+version);

//        DashboardModel dashboardModel=new DashboardModel(new DashboardController(new Dashboard()));
//        dashboardModel.viewProducts();

        Register register=new Register();
        register.getInput();

    }
}
