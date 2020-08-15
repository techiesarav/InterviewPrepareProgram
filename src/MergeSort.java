

public class MergeSort {

	public static void main(String[] args) {
	      int[] intArray = {2, 1 ,3 ,1 ,2};
	      int count = 0;
	      count += mergeSort(intArray,0,intArray.length,count);
	      for(int i=0; i<intArray.length;i++) {
	    	  System.out.println(intArray[i]+",");
	      }
		}
	private static int mergeSort(int[] intArray, int start, int end,int count) {
		if(end-start <2) {
			return 0;
		}
		int mid = (start +end) /2;
	    mergeSort(intArray, start, mid,count);
	    mergeSort(intArray, mid , end,count);
	    count += merge(intArray, start, mid, end,count);
	    return count;
	}
	
	private static int merge(int[] intArray, int start , int mid , int end,int count) {
		if(intArray[mid-1] <= intArray[mid]) {
			return 0;
		}
		int i = start;
		int j = mid;
		while (i < mid && j<end) {
			if(intArray[i] <= intArray[j]) {
				
						}else {
							int temp = intArray[i];
							intArray[i]= intArray[j];
							intArray[j]= temp;
							j++;
			}
		}
		return count;
	}

}
