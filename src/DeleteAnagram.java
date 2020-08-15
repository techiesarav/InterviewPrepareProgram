import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DeleteAnagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int[] count = new int[26];
        for(int i=0;i<c1.length;i++){
            count[c1[i] -97]++;
        }
        for(int j=0;j<c2.length;j++){
            int val =count[c2[j]-97];
            if(val ==0){
                count[c2[j]-97] ++;
            }else{
                count[c2[j]-97] --;
            }
        }
        int cal =Arrays.stream(count).filter(i -> i!=0).map(i ->i).sum();
        return cal;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D://rr.txt"));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
