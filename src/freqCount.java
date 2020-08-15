import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class freqCount {

    // Complete the freqQuery function below.
	 static List<Integer> freqQuery(int[][] queries , int q) {
	        Map<Integer,Integer> inpMap = new HashMap<>();
	        Map<Integer,List<Integer>> freqMap = new HashMap<>();
	        List<Integer> outList = new ArrayList();
	        for(int i = 0;i<q;i++){
	            int op = queries[i][0];
	            int data = queries[i][1];
	            if(op ==1){
	                if(inpMap.containsKey(data)){
	                    int val = inpMap.get(data);
	                    inpMap.put(data,val+1);
	                    List<Integer> al = freqMap.get(val+1);
	                    if(al == null){
	                        al = new ArrayList<>();
	                        al.add(data);
		                    freqMap.put(val+1,al);
	                    }else {
	                        al.add(data);
		                    freqMap.put(val+1,al);
	                    }
	                   
	                }else{
	                    inpMap.put(data,1);
	                    List<Integer> al = freqMap.get(1);
	                    if(al == null){
	                        al = new ArrayList<>();
	                    }
	                    al.add(data);
	                    freqMap.put(1,al);
	                }
	            }else if(op ==2){
	                if(inpMap.containsKey(data)){
	                    int val = inpMap.get(data);
	                    List<Integer> al = freqMap.get(val);
	                    if(al !=null && al.indexOf(data) !=-1) {
	                    	al.remove(al.indexOf(data));
	                    	freqMap.put(val,al);
	                    }
	                    inpMap.put(data,val-1);
	                }else{
	                    inpMap.remove(data);
	                    List<Integer> al = freqMap.get(1);
	                    if(al != null && al.indexOf(data) !=-1){
	                        al.remove(al.indexOf(data));
	                        freqMap.put(1,al);
	                    }    
	                }
	            }else if(op ==3){
	               List<Integer> al =freqMap.get(data);
	                if(al != null && !al.isEmpty()){
	                    outList.add(1);
	                }else{
	                    outList.add(0);
	                }
	            }
	        }
	        return outList;
	    }

      public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in))) {
            
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];
           
            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }
          
            List<Integer> ans = freqQuery(queries,q);
            
            for(int i :ans) {
            	System.out.println(i);
            }
          
            try (BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter("D:\\rr.txt"))) {
            
                bufferedWriter.write(ans.stream().map(Object::toString)
                            .collect(joining("\n")) + "\n");
            }
        }
    }
}
