package tki.ecommerce.DTO;

public class Address {
    String doorno;
    String streetname;
    String locality;

    public Address(String doorno, String streetname,String locality) {
        this.doorno = doorno;
        this.locality = locality;
        this.streetname=streetname;
    }
}
