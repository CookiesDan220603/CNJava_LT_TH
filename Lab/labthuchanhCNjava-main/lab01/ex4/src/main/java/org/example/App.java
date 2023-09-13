package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.validator.routines.UrlValidator;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class App 
{
    public static void main( String[] args )
    {
//                "ftp://ftp.arin.net/pub/stats/arin/delegated-arin-extended-latest";
        String[] schemes = {"http","https","ftp"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        if(args.length==0){
            System.out.println("Please specify an URL to a file");
        }
        else if(!urlValidator.isValid(args[0])){
            System.out.println("This is not a valid URL");
        }
        else{
            String fromFile = args[0];
            String toFile = System.getProperty("user.dir") +"/file.txt";
            try {
                FileUtils.copyURLToFile(new URL(fromFile), new File(toFile), 10000, 10000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
