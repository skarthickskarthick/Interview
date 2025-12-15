package tki.ecommerce.DTO;

public class UserInfo {
   static int id=1;
   public int userid;
   public String name;
    public String password;
   public Address address;

    public UserInfo(int userid, String name, String password, Address address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
    }
    public UserInfo( String name, String password, Address address) {
       this.userid=id++;
        this.name = name;
        this.password = password;
        this.address = address;
    }
}
