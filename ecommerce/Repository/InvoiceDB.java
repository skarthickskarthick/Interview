package tki.ecommerce.Repository;

import tki.ecommerce.DTO.Invoice;
import tki.ecommerce.DTO.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDB {
    public static List<Invoice> invoiceList;
    static InvoiceDB invoiceDB;

    public static  InvoiceDB getInstance()
    {
        if(invoiceDB==null)
        {
            invoiceDB=new InvoiceDB();
            invoiceList=new ArrayList<>();
        }
        return invoiceDB;
    }
}
