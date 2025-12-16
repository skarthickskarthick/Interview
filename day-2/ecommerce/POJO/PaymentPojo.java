package tki.ecommerce.POJO;

import java.util.Date;

public class PaymentPojo {
    private int payid;
    private float amount;
    private String paymode;
    private String status;
    private Date paydate;
    private UserPojo userPojo;

    public PaymentPojo(int payid, float amount, String paymode, String status, Date paydate, UserPojo userPojo) {
        this.payid = payid;
        this.amount = amount;
        this.paymode = paymode;
        this.status = status;
        this.paydate = paydate;
        this.userPojo = userPojo;
    }

    public PaymentPojo(float amount, String paymode, String status, Date paydate, UserPojo userPojo) {
        this.amount = amount;
        this.paymode = paymode;
        this.status = status;
        this.paydate = paydate;
        this.userPojo = userPojo;
    }

    public PaymentPojo() {
    }

    public int getPayid() {
        return payid;
    }

    public void setPayid(int payid) {
        this.payid = payid;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public UserPojo getUserPojo() {
        return userPojo;
    }

    public void setUserPojo(UserPojo userPojo) {
        this.userPojo = userPojo;
    }
}
