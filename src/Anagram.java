import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagram {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int result = 0;
        Set<String> res = new HashSet<String>();
        for(int i=0;i<s.length();i++){
        List<String> strList = new ArrayList<>();
        
        int k=i+1;
        for(int j=0;j<s.length();j++){
            if(k <= s.length()){
                String s1 = s.substring(j,k);
                strList.add(s1);
            }
            k++;
        }
        result = result +checkAnagram(strList);
        }
        return result;    
    }

    private static int checkAnagram(List<String> strList){
        int result = 0;
        int len = strList.size();
        for(int i=0;i<len;i++){
            for(int j = i+1;j<len;j++){
               if(isAnagram(strList.get(i),strList.get(j))){
                result = result+1;
               }
            }

        }
        return result;
    }
    
    private static boolean isAnagram(String s1,String s2){
        int[] charCount = new int[26];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(int i=0;i<c1.length;i++){
            charCount[c1[i]-97]++;
            charCount[c2[i]-97]--;
        }
        for(int i=0;i<26;i++){
            if(charCount[i] !=0){
               return false; 
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\rr.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
