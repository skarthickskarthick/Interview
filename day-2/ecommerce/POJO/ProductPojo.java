package tki.ecommerce.POJO;

public class ProductPojo {


    private int productid;
    private String name;
    private String description;
    private int quantity;
    private float price;
    private CategoryPojo categoryPojo;
    public ProductPojo() {
    }

    public ProductPojo(int productid, String name, String description, int quantity, float price) {
        this.productid = productid;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductPojo(int productid, String name, String description, int quantity, float price, CategoryPojo categoryPojo) {
        this.productid = productid;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.categoryPojo = categoryPojo;
    }

    public ProductPojo(String name, String description, int quantity, float price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public CategoryPojo getCategoryPojo() {
        return categoryPojo;
    }

    public void setCategoryPojo(CategoryPojo categoryPojo) {
        this.categoryPojo = categoryPojo;
    }

    @Override
    public String toString() {
        return "pid: "+productid+" name: "+name+" description: "+description+" quantity: "+quantity+
                " price: "+price+" category id: "+categoryPojo.getCategoryid()+" category name: "+categoryPojo.getName();
    }
}
