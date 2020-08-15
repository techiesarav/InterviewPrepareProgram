import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class hashtablecheck {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String,Integer> magTable = new Hashtable<String,Integer>();
        Map<String,Integer> noteTable = new Hashtable<String,Integer>();

        for(String mag : magazine){
           if(magTable.containsKey(mag)){
               int value = magTable.get(mag) +1;
               magTable.put(mag,value);
           }else {        	   
        	   magTable.put(mag,1);
           }
        }

        for(String n : note){
           if(noteTable.containsKey(n)){
               int value = noteTable.get(n)+1;
               noteTable.put(n,value);
           }else {        	   
        	   noteTable.put(n,1);
           }
        }
        
        String res = "Yes";
        for(String k : noteTable.keySet()){
            if(magTable.containsKey(k)){
                int magValue = magTable.get(k);
                int noteValue = noteTable.get(k);
                if(noteValue != magValue){
                    res = "No";
                }
            }else{
                res = "No";
            }
        }
        System.out.println(res);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
