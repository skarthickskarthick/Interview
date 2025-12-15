package tki.ecommerce.View;

public class MainEntry {
    static String version="1.0.0";
    public static void main(String[] args) {
        MainEntry mainEntry=new MainEntry();
        mainEntry.init();
    }
    public void init()
    {
        System.out.println("welcome to e-commerce website");
        System.out.println("version : "+version);

        Register register=new Register();
        register.getInput();
    }
}
