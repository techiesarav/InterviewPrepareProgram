import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

class checke implements Comparator<Integer>{
	
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 -o2;
	}
}

public class PriorQue {
	

	public static void main(String[] args) {
		
        PriorityQueue<Integer> queue = new PriorityQueue<>(new checke());
  
        // Use add() method to add elements into the Queue 
        queue.add(10); 
        queue.add(15); 
        queue.add(30); 
        queue.add(20); 
        queue.add(5); 
        queue.add(25); 
        
        System.out.println("iterator");
        Iterator<Integer> iter = queue.iterator();
        while(iter.hasNext()) {
        	System.out.println(iter.next());
        }
  
        System.out.println("Poll");
        while(!queue.isEmpty()){
        	System.out.println(queue.poll());
        }

	}

}
