package tki.ecommerce.Repository;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {

    public static Connection connection;


    public static  Connection getConnection()
    {
        if(connection==null)
        {
           try
           {
               Class.forName("com.mysql.cj.jdbc.Driver");
               connection = DriverManager.getConnection(
                       "jdbc:mysql://localhost:3306/ecommerce", "root", "9488");
               //System.out.println(connection);
           }
           catch (Exception e)
           {
               System.out.println(e);
           }
        }
       // System.out.println(connection);
        return connection;
    }
}
