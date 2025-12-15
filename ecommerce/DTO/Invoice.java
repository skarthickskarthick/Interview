package tki.ecommerce.DTO;

public class Invoice {
    static int id=1;
    public int invoiceid;
    public UserInfo user;
    public Products products;
    int quantity;
    public float totalAmount;

    public Invoice( UserInfo user, Products products, float totalAmount,int quantity) {
        invoiceid = id++;
        this.user = user;
        this.products = products;
        this.totalAmount = totalAmount;
        this.quantity=quantity;
    }

    @Override
    public String toString() {
        return "invoice id: "+invoiceid+" userid: "+user.userid+" username: "+user.name+" productid: "+products.productid+
                " productname: "+products.name+" Quantity: "+quantity+" total amount: "+totalAmount;
    }
}
