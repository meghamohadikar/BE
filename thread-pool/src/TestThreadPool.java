import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
	 public static void main(String[] args) {  
		 ExecutorService ex=Executors.newFixedThreadPool(5);
	        for (int i = 0; i < 10; i++) {  

		 Runnable obj=new WorkerThread("Megha");
		 ex.execute(obj);
	        }
		 ex.shutdown();
		 while (!ex.isTerminated()) {   }  
	     System.out.println("Finished all threads");  

	 }
}