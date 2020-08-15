import java.util.Arrays;
import java.util.List;

public class DroppedRequest {

	public static void main(String[] args) {
		List<Integer> requestTime = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 14, 14, 16, 16, 16, 16, 16, 16, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20);
		System.out.println(droppedRequests(requestTime));

	}
	
	public static int droppedRequests(List<Integer> requestTime) {

	    int[] A = getRequestFrequency(requestTime);
	    int count1 = 0;
	    int last10 = 0 ;
	    int last60 = 0;
	    for (int i = 0; i < A.length; i++) {
	        if(i-10 >= 0){
	            last10 -= A[i-10];
	        }
	        if(i-60 >= 0){
	            last60 -= A[i-60];
	        }
	        last10 += A[i];
	        last60 += A[i];
	        int dropped = 0;
	        int rem = A[i];
	        if(A[i]>3){
	            dropped += A[i] - 3;
	            rem -= dropped;
	        }
	        if(last10 > 20) {
	            int toDrop = last10 - 20;
	            if(rem > toDrop) {
	                dropped += toDrop;
	                rem -= toDrop;
	            }else {
	                dropped += rem;
	                rem = 0;
	            }
	        }
	        if(last60 > 60) {
	            int toDrop = last60 - 60;
	            if(rem > toDrop) {
	                dropped += toDrop;
	                rem -= toDrop;
	            }else {
	                dropped += rem;
	                rem = 0;
	            }
	        }
	        count1 += dropped;
	        A[i] = rem;
	    }
	    return count1;
	}

	public static int[] getRequestFrequency(List<Integer> requestTime) {

	    int lastElement = requestTime.get(requestTime.size() - 1);
	    int[] result = new int[lastElement];
	    for (Integer integer : requestTime) {
	        result[integer - 1]++;
	    }
	    return result;
	}

}
