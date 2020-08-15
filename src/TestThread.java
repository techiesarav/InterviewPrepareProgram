import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TestThread extends Thread {
	
	Thread t ;
	
	TestThread(){
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("run");
	}
	public static void main(String[] args) throws InterruptedException {
		doTaskWithResultInWorker();
		// TODO Auto-generated method stub
//		TestThread t2 = new TestThread();
//		Thread tt = new Thread(t1);
//		t1.start();
//		new TestThread();
	}
	
	private static void doTaskWithResultInWorker() throws InterruptedException {
	    Callable<Integer> callable = new Callable<Integer>() {
	        @Override
	        public Integer call() throws Exception {
	            System.out.println("Task starts");
//	            Thread.sleep(1000);
	            int result = 0;
	            for (int i=0; i<=100; i++) {
	            	System.out.println(i);
	                result += i;
	            }
	            System.out.println("Task finished and return result");
	            return result;
	        }
	    };
	    Callable<Integer> callable1 = new Callable<Integer>() {
	        @Override
	        public Integer call() throws Exception {
	            System.out.println("Task1 starts");
//	            Thread.sleep(1000);
	            int result = 0;
	            for (int i=100; i<=200; i++) {
	            	System.out.println(i);
	                result += i;
	            }
	            System.out.println("Task1 finished and return result");
	            return result;
	        }
	    };
	    ExecutorService ex = Executors.newFixedThreadPool(2);
		List<Future<Integer>> ftList =ex.invokeAll(Arrays.asList(callable,callable1));
	    ftList.stream().forEach(action ->{
	    try {
	        System.out.println("Before futureTask.get()");
	        System.out.println("Result:" + action.get());
	        System.out.println("After futureTask.get()");
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    } catch (ExecutionException e) {
	        e.printStackTrace();
	    }
	    });
	}
	
	

}
