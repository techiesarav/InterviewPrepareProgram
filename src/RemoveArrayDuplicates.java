
/**
 * Remove array duplicates with O(1) time and space
 * @author ramsa
 *
 */
public class RemoveArrayDuplicates {

	public static void main(String[] args) {
		int a[] = {1,1,2,2,3,3,4,4,5,5};
		int j=0;
		for(int i=1;i<a.length;i++) {
			if(a[i] !=a[j]) {
				a[++j]=a[i];
			}
		}
		System.out.println(++j);
	}
}
