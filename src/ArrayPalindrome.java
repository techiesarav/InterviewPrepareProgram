
import java.util.ArrayList;

public class ArrayPalindrome {
    static int length = 0;
    static int i, j;
    //different inputs for the program to check!
    static int[] a = {34,10,15,55,25,34};
    // static int[] a = {74,10,15,10,40,34};
    //static int[] a = {10,15,10};
    public static void main(String[] args){
        length = a.length;
        int mid = length/2;
        i =0;
        j = length-1;
        do {
            if(a[i]==-1){
                i++;
            }
            if(a[j]==-1){
                j--;
            }
            if(a[i]==a[j]){
                i++;
                j--;
            }
            else {
                if(a[i]<a[j]){
                    //look up for elements by iterating from left side
                    leftLookUpAndFix();
                }
                else {
                    //look up for elements to sum up by from right side
                    rightLookUpAndFix();
                }

            }
        }
        while(i<=j);
        for (int value:a) {
            System.out.print(value+"\t");
        }
        System.out.println("Output ->\t" +length);
    }

    private static void rightLookUpAndFix() {
        for (int k = j-1; k >i ; k--) {
          if(a[j]+a[k]==a[i]){
              a[j] = a[k] + a[j];
              a[k] = -1;
              i++;
              j--;
              length--;
          }
          else {
              continue;
          }
        }
    }

    private static void leftLookUpAndFix(){
        for (int k = 0; k <j ; k++) {
           if(a[i]+a[k]==a[j]){
               a[i] = a[i] + a[k];
               a[k] = -1;
               i++;
               j--;
               length--;

           }
           else {
               continue;
           }
        }
    }
}
