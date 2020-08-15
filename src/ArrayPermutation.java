

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayPermutation {

	public static void main(String[] args) {
		    int[] inpArr = {0,1,2};
	        int n = inpArr.length; 
	        ArrayPermutation arrperm = new ArrayPermutation();
	        Permutation permutation = arrperm.new Permutation(); 
	        permutation.permute(inpArr, 0, n-1);
	}

	public class Permutation 
	{ 
	    /** 
	     * permutation function 
	     * @param str string to calculate permutation for 
	     * @param l starting index 
	     * @param r end index 
	     */
	    private void permute(int[] inpArr, int l, int r) 
	    { 
	        if (l == r) 
	           System.out.println(Arrays.toString(inpArr));
	        else
	        { 
	            for (int i = l; i <= r; i++) 
	            { 
	            	inpArr = swap(inpArr,l,i); 
	                permute(inpArr, l+1, r); 
	                inpArr= swap(inpArr,l,i); 
	            } 
	        } 
	    } 
	  
	    /** 
	     * Swap Characters at position 
	     * @param a string value 
	     * @param i position 1 
	     * @param j position 2 
	     * @return swapped string 
	     */
	    public int[] swap(int[] inpArr, int i, int j) 
	    { 
	        int temp; 
	        temp = inpArr[i] ; 
	        inpArr[i] = inpArr[j]; 
	        inpArr[j] = temp; 
	        return inpArr; 
	    } 
	  
	} 
}
