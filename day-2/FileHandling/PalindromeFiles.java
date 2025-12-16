package tki.FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PalindromeFiles {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number");
        int n=sc.nextInt();
        PalindromeFiles palindromeFiles=new PalindromeFiles();
        boolean palindrome=palindromeFiles.isPalindrome(n);
        String result="not palindrome";
        if(palindrome)
            result="palindrome";
        System.out.println(result);
        System.out.println("1.write to file 2.exit/any no");
        int option= sc.nextInt();
        if(option==1)
        {
            File file=palindromeFiles.getFile();
            String data=n+"  "+result;
            if(palindromeFiles.writeToFile(file,data))
                System.out.println("file updated");
            else
                System.out.println("file not updated");
        }
    }
    public boolean isPalindrome(int n)
    {
        if(n<=0)
            n=n*-1;
        int input=n;
        int output=0;

        while(n>0)
        {
            int rem=n%10;
            output=output*10+rem;
            n=n/10;
        }
        if(input==output)
            return true;
        return false;
    }
    public  File getFile() throws IOException {
        String userHome = System.getProperty("user.home");
        Path downloadsPath = Paths.get(userHome, "Downloads1");
        String folderName = "new1";
        String fileName = "example.txt";
        Path newFolderPath = downloadsPath.resolve(folderName);
        Path newFilePath = newFolderPath.resolve(fileName);
        Files.createDirectories(newFolderPath);
        String path=newFilePath.toString();
        System.out.println(path);

        File file=new File(path);
        return file;
    }
    public boolean writeToFile(File file,String data)  {

        try {
            FileWriter fileWriter=new FileWriter(file,true);

            fileWriter.write(data);
            fileWriter.write("\n");

            fileWriter.close();
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return false;

    }
}
