import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumBribesHackerRank {


    // Complete the minimumBribes function below.
    static String minimumBribes(int[] q) {
        String res =null;
        int ans =0;
        for(int i=q.length -1;i>=0;i--){
            if(q[i]-(i+1) >2)
                res="Too chaotic";
            for(int j=(Math.max(0,q[i]-2));j<i;j++){
                if(q[j] >q[i])
                    ans++;
            }    
        }
        if(res == null){
            res = String.valueOf(ans);
        }
       return res ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        List<String> st = new ArrayList<>();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            st.add(minimumBribes(q));
        }

        for(String s:st){
            System.out.println(s);
        }

        scanner.close();
    }
}
