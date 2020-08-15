import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class checker implements Comparator<Integer>{
	
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 -o2;
	}
}

public class countingsort {

	// Complete the activityNotifications function below.
	 static int activityNotifications(int[] expenditure, int d) {
	        int n = expenditure.length;
	        checker ch = new checker();
	        boolean isEven = d%2 ==0 ? true :false;
	        int notification = 0;
	        double median = 0;
	        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(ch); 
	        for(int i=0;i<n-d;i++){
	           int medianArr[] = new int[d];
	          System.arraycopy(expenditure,i,medianArr,0,d);
	        int max = Arrays.stream(medianArr).max().getAsInt(); 
	        int min = Arrays.stream(medianArr).min().getAsInt(); 
	        int range = max - min + 1; 
	        int count[] = new int[range]; 
	        int output[] = new int[medianArr.length]; 
	        for (int j = 0; j < medianArr.length; j++) 
	        { 
	            count[medianArr[j] - min]++; 
	        } 

	        for (int j = 1; j < count.length; j++) 
	        { 
	            count[j] += count[j - 1]; 
	        } 

	        for (int j = medianArr.length - 1; j >= 0; j--) 
	        { 
	            output[count[medianArr[j] - min] - 1] = medianArr[j]; 
	            count[medianArr[j] - min]--; 
	        } 

	        for (int j = 0; i < medianArr.length; i++) 
	        { 
	            medianArr[j] = output[j]; 
	        }

	        if( i !=0){
	               if(expenditure[i+d-1] >= 2*median){
	                   notification++;
	               }
	           }
	           if(isEven){
	               int val = d/2;
	               median =( output[val-1]+output[val]) /2;
	           }else{
	               int val = (d+1)/2;
	               median = output[val-1];
	           } 
	        }
	        return notification;
	    
	    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D://rr.txt"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
