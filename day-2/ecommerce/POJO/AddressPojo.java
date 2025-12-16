package tki.ecommerce.POJO;

public class AddressPojo {
    private int addressid;
    private String doorno;
   private String streetname;
   private String locality;

    public AddressPojo() {
    }

    public AddressPojo(int addressid, String doorno, String streetname, String locality) {
        this.addressid = addressid;
        this.doorno = doorno;
        this.streetname = streetname;
        this.locality = locality;
    }

    public AddressPojo(String doorno, String streetname, String locality) {
        this.doorno = doorno;
        this.streetname = streetname;
        this.locality = locality;
    }

    public String getDoorno() {
        return doorno;
    }

    public void setDoorno(String doorno) {
        this.doorno = doorno;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }
}
