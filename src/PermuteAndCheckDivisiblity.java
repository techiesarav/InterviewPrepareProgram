import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class PermuteAndCheckDivisiblity {

    static boolean isValid(char a, char b, char c){
        int x= a-'0';
        int y= b-'0';
        int z= c-'0';
        if( (4*x+2*y+z)%8==0 )
        return true;
        if( (4*x+2*z+y)%8==0 )
        return true;
        if( (4*y+2*x+z)%8==0 )
        return true;
        if( (4*y+2*z+x)%8==0 )
        return true;
        if( (4*z+2*y+x)%8==0 )
        return true;
        if( (4*z+2*x+y)%8==0 )
        return true;
        return false;

    }

    // Complete the solve function below.
    static String solve(String n) {
        
        if(n.length()>=3){
            for(int i=0;i<n.length();i++){
            for(int j=i+1;j<n.length();j++){
                for(int k=j+1;k<n.length();k++){
                    if(isValid(n.charAt(i),n.charAt(j),n.charAt(k) ) ){
                        return "YES";
                    }

                }
            }
        }
        }else if(n.length()==2){
            int x=n.charAt(0)-'0';
            int y=n.charAt(1)-'0';
            if((2*x+y)%8==0)
            return "YES";
            if((2*y+x)%8==0)
            return "YES";
        }else if(n.length()==1){
            if((n.charAt(0)-'0')%8==0)
            return "YES";
        }
        return "NO";

    }

    private static void permuteString(String inp,int start,int end,
                    List<String> inpStringList){

                        if(start == end){
                            inpStringList.add(inp);
                        }

                        for(int i=start;i<=end;i++){
                            inp =swap(inp,start,i);
                            permuteString(inp,start+1,end,inpStringList);
                            inp =swap(inp,start,i);
                        }

                    }

        private static String swap(String inp,int start,int end){
            char[] inpArr = inp.toCharArray();
            char temp = inpArr[start];
            inpArr[start]=inpArr[end];
            inpArr[end] = temp;
            return String.valueOf(inpArr);
        }            

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String n = scanner.nextLine();

            String result = solve(n);
            System.out.println(result);

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
