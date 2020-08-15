import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CollectionCheck {

	public static void main(String[] args) {
		
		//ConcurrentModificationException
		 List<Integer> l = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 4));
		 /*   for (int el : l) {
		        if (el < 3) {
		            System.out.println(l.remove(el));
		        }
		    }
		    */
		 l.remove(2);
		 for(int el:l) {
			 System.out.println(el);
		 }
		 //Remove while iterating over collection
		 Iterator<Integer> it = l.iterator();
		    while (it.hasNext()) {
		        int el = it.next();
		        if (el < 3) {
		            it.remove();
		        }
		    }
		    LinkedList<Character> st = new LinkedList<>();
		    Queue<Character> st1 = new LinkedList<>();
		    List<Character> st2 = new Stack<Character>();
	}

}
