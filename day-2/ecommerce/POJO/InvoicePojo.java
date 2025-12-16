package tki.ecommerce.POJO;

public class InvoicePojo {
    private int invoiceid;
    private UserPojo userPojo;
    private ProductPojo productPojo;
    private int quantity;
    private float total;

    public InvoicePojo(UserPojo userPojo, ProductPojo productPojo, int quantity, float total) {
        this.userPojo = userPojo;

        this.productPojo = productPojo;
        this.quantity = quantity;
        this.total = total;
    }
    public InvoicePojo()
    {

    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public ProductPojo getProductPojo() {
        return productPojo;
    }

    public void setProductPojo(ProductPojo productPojo) {
        this.productPojo = productPojo;
    }

    public UserPojo getUserPojo() {
        return userPojo;
    }

    public void setUserPojo(UserPojo userPojo) {
        this.userPojo = userPojo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
