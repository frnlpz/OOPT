package Lab3;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.CharBuffer;

public class LaboratoryThree {

    public static void main(String[] args) {
        counter ("fra");
    }

    protected static void printException (Exception e){
         System.out.println("The next exception has occurred: "+e.getMessage()+"\n");
    }

    private static void counter (String s){
        int count = 0;
        try {
        URL url = new URL("http://www.puzzlers.org/pub/wordlists/pocket.txt");
            String inputLine;
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            while ((inputLine = in.readLine()) != null)
                if (inputLine.contains(s))
                    count++;
            in.close();
        } catch (IOException e) {
            printException(e);
        }
        System.out.println("Letters '"+s+"' appear in the URL "+count+" times.");
    }
}
