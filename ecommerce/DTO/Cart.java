package tki.ecommerce.DTO;

public class Cart {
    static int id=1;
    public int cartid;
    public UserInfo user;
    public Products products;
    int quantity;

    public Cart(UserInfo user, Products products, int quantity) {
        this.cartid = id++;
        this.user = user;
        this.products = products;
        this.quantity = quantity;
    }
    public String toString() {
        return "cart id: "+cartid+" userid: "+user.userid+" username: "+user.name+" productid: "+products.productid+
                " productname: "+products.name+" Quantity: "+quantity;
    }
}
