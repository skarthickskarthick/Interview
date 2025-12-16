package tki.ecommerce.POJO;

public class Payment {
    private UserPojo userPojo;
    private float amount;

    private String mode;

    public Payment(UserPojo userPojo, String mode, float amount) {
        this.userPojo = userPojo;
        this.mode = mode;
        this.amount = amount;
    }

    public Payment() {
    }

    public UserPojo getUserPojo() {
        return userPojo;
    }

    public void setUserPojo(UserPojo userPojo) {
        this.userPojo = userPojo;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
