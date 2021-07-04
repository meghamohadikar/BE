package programs;

//he stop() method of thread class terminates the thread execution. Once a thread is stopped, 
//it cannot be restarted by start() method.
public class Test2 extends Thread{
	public void run() 
    { 
        System.out.print("Hello..."); 
    } 
    public static void main(String args[]) throws InterruptedException 
    { 
    	Test2 T1 = new Test2(); 
        T1.start(); 
      //  T1.sleep(5000);
        T1.stop(); 
        T1.start(); 
    } 

}
