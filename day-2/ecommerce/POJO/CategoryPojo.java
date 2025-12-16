package tki.ecommerce.POJO;

public class CategoryPojo {
    private int categoryid;
    private String name;

    public CategoryPojo(int categoryid, String name) {
        this.categoryid = categoryid;
        this.name = name;
    }
    public CategoryPojo()
    {

    }
    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
