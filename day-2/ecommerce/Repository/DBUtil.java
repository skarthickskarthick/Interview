package tki.ecommerce.Repository;

import tki.ecommerce.DTO.Address;
import tki.ecommerce.DTO.LoginInfo;
import tki.ecommerce.DTO.Products;
import tki.ecommerce.DTO.UserInfo;
import tki.ecommerce.POJO.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

    public void insertUser(UserPojo u, AddressPojo a) throws Exception
    {
        String sql = "INSERT INTO user(name,email,password,phone) VALUES(?,?,?,?)";
        Connection c = DbConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,u.getName());
            ps.setString(2,u.getEmail());
            ps.setString(3,u.getPassword());
            ps.setString(4,u.getPhone());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) u.setUserid(rs.getInt(1));

        String sql1 = "INSERT INTO address(doorno,streetname,locality,userid) VALUES(?,?,?,?)";
        PreparedStatement ps1 = c.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
        ps1.setString(1,a.getDoorno());
        ps1.setString(2,a.getStreetname());
        ps1.setString(3,a.getLocality());
        ps1.setInt(4,u.getUserid());


        ps1.executeUpdate();
        ResultSet rs1 = ps1.getGeneratedKeys();
        if(rs1.next()) a.setAddressid(rs1.getInt(1));

    }

    public UserPojo getUser(LoginInfo loginInfo) throws Exception
    {
        String sql = "SELECT * FROM user WHERE email=? and password=?";
        Connection c = DbConnection.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1,loginInfo.email);
        ps.setString(2,loginInfo.password);
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            UserPojo userPojo = new UserPojo();
            userPojo.setUserid(rs.getInt("userid"));
            userPojo.setName(rs.getString("name"));
            userPojo.setEmail(rs.getString("email"));
            userPojo.setPassword(rs.getString("password"));
            userPojo.setPhone(rs.getString("phone"));

            return userPojo;

        }
        return null;
    }

    public ProductPojo getByProductid(int productid) throws Exception
    {
        String sql = "SELECT * FROM product WHERE productid=?";
        Connection c = DbConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,productid);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                ProductPojo p = new ProductPojo();
                p.setProductid(rs.getInt("productid"));
                p.setName(rs.getString("pname"));
                p.setDescription(rs.getString("description"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getInt("price"));

                return p;

        }
            return null;
    }

    public List<ProductPojo> getAllProducts() throws Exception
    {
        List<ProductPojo> list=new ArrayList<>();
        String sql = "SELECT p.productid,p.pname,p.description, p.quantity,p.price,c.categoryid,c.name from product p,category c";
        Connection c = DbConnection.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ProductPojo p = new ProductPojo();
            p.setProductid(rs.getInt("productid"));
            p.setName(rs.getString("pname"));
            p.setDescription(rs.getString("description"));
            p.setQuantity(rs.getInt("quantity"));
            p.setPrice(rs.getFloat("price"));

            CategoryPojo categoryPojo=new CategoryPojo();
            categoryPojo.setCategoryid(rs.getInt("categoryid"));
            categoryPojo.setName(rs.getString("name"));
            p.setCategoryPojo(categoryPojo);
            list.add(p);
        }

        return list;
    }
    public List<ProductPojo> getProductsByCategory(String name) throws Exception
    {
        List<ProductPojo> list=new ArrayList<>();
        String sql = "SELECT p.productid,p.pname,p.description, p.quantity,p.price,c.categoryid,c.name from product p,category c where c.name=?";
        Connection c = DbConnection.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ProductPojo p = new ProductPojo();
            p.setProductid(rs.getInt("productid"));
            p.setName(rs.getString("pname"));
            p.setDescription(rs.getString("description"));
            p.setQuantity(rs.getInt("quantity"));
            p.setPrice(rs.getFloat("price"));

            CategoryPojo categoryPojo=new CategoryPojo();
            categoryPojo.setCategoryid(rs.getInt("categoryid"));
            categoryPojo.setName(rs.getString("name"));
            p.setCategoryPojo(categoryPojo);
            list.add(p);
        }

        return list;
    }
    public void updateQuantity(int productid,int quantity) throws Exception {
        String sql = "update product set quantity=? where productid=? ";
        Connection c = DbConnection.getConnection();
        PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ProductPojo productPojo=getByProductid(productid);
        int val=productPojo.getQuantity();
        if(val<=1)
            val=0;
        else val-=1;
        ps.setInt(1, val);
        ps.setInt(2, productid);
        ps.executeUpdate();
    }
    public void generateInvoice(Payment payment,ProductPojo productPojo,int quantity,int payid) throws Exception
    {
        String sql = "INSERT INTO invoice(quantity,total) VALUES(?,?)";
        Connection c = DbConnection.getConnection();
        PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,quantity);
        ps.setFloat(2,payment.getAmount());

        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        int invoiceid=-1;
        if(rs.next())
            invoiceid=rs.getInt(1);
       insertInvoicemap(invoiceid,payment,productPojo,payid);

    }
    public void insertInvoicemap(int invoiceid,Payment payment,ProductPojo productPojo,int payid) throws Exception
    {
        String sql = "INSERT INTO invoicemap(invoiceid,userid,productid,payid) VALUES(?,?,?,?)";
        Connection c = DbConnection.getConnection();
        PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,invoiceid);
        ps.setInt(2,payment.getUserPojo().getUserid());
        ps.setInt(3,productPojo.getProductid());
        ps.setInt(4,payid);

        ps.executeUpdate();


    }
    public int makePayment(Payment payment) throws Exception
    {
        String sql = "INSERT INTO payment(amount,status,paymode,paydate) VALUES(?,?,?,?)";
        Connection c = DbConnection.getConnection();
        PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setFloat(1,payment.getAmount());
        ps.setString(2,"completed");
        ps.setString(3,payment.getMode());
        LocalDate localDate=LocalDate.now();
        ps.setDate(4, Date.valueOf(localDate));

        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        int payid=-1;
        if(rs.next())
            payid=rs.getInt(1);
//        System.out.println("hello"+payment.getUserPojo().getUserid());
        paymentMap(payid,payment.getUserPojo().getUserid());
        return payid;
    }
    public void paymentMap(int payid,int userid) throws Exception
    {
        //System.out.println(userid);
        String sql = "INSERT INTO paymentmap(payid,userid) VALUES(?,?)";
        Connection c = DbConnection.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1,payid);
        ps.setFloat(2,userid);
        ps.executeUpdate();
    }

//    public List<InvoicePojo> getInvoiceByuserid(int  userid) throws Exception
//    {
//        List<ProductPojo> list=new ArrayList<>();
//        String sql = "SELECT p.productid,p.pname,p.description, p.quantity,p.price,c.categoryid,c.name from product p,category c where c.name=?";
//        Connection c = DbConnection.getConnection();
//        PreparedStatement ps = c.prepareStatement(sql);
//        ps.setString(1,name);
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()) {
//            ProductPojo p = new ProductPojo();
//            p.setProductid(rs.getInt("productid"));
//            p.setName(rs.getString("pname"));
//            p.setDescription(rs.getString("description"));
//            p.setQuantity(rs.getInt("quantity"));
//            p.setPrice(rs.getFloat("price"));
//
//            CategoryPojo categoryPojo=new CategoryPojo();
//            categoryPojo.setCategoryid(rs.getInt("categoryid"));
//            categoryPojo.setName(rs.getString("name"));
//            p.setCategoryPojo(categoryPojo);
//            list.add(p);
//        }
//
//        return list;
//    }
public List<ProductPojo> getAllProducts1() throws Exception
{
    List<ProductPojo> list=new ArrayList<>();
    String sql = "SELECT  distinct p.productid,p.pname,p.description, p.quantity,p.price,c.categoryid,c.name from product p,category c where p.categoryid=c.categoryid";
    Connection c = DbConnection.getConnection();
    PreparedStatement ps = c.prepareStatement(sql);

    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
        ProductPojo p = new ProductPojo();
        p.setProductid(rs.getInt("productid"));
        p.setName(rs.getString("pname"));
        p.setDescription(rs.getString("description"));
        p.setQuantity(rs.getInt("quantity"));
        p.setPrice(rs.getFloat("price"));

        CategoryPojo categoryPojo=new CategoryPojo();
        categoryPojo.setCategoryid(rs.getInt("categoryid"));
        categoryPojo.setName(rs.getString("name"));
        p.setCategoryPojo(categoryPojo);
        list.add(p);
    }

    return list;
}

}
