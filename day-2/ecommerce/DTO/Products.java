package tki.ecommerce.DTO;

public class Products {
    public int productid;
    public String name;
    public String description;
    public float price;
    public Tag tag;
    public int quantity;

    public Products(int productid, String name, String description, float price, Tag tag, int quantity) {
        this.productid = productid;
        this.name = name;
        this.description = description;
        this.price = price;
        this.tag = tag;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "productid: "+productid+" name: "+name+" description: "+description+" price: "+price+" tag: "+tag+" quantity: "+quantity;
    }
}
