import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
	public static void main(String[] args) throws InterruptedException {
	HashMap m = new HashMap();
	Temp t = new Temp();
	m.put(t, "element");
	System.out.println(m);
	
	t=null;    //will available for GC
	//calling garbage collector
	System.gc();
	Thread.sleep(3000);
	System.out.println(m);

	WeakHashMap m1 = new WeakHashMap();
	Temp t1 = new Temp();
	m1.put(t1, "element");
	System.out.println(m1);
	
	t1=null;    //will available for GC
	//calling garbage collector
	System.gc();
	Thread.sleep(3000);
	System.out.println(m1);

	}
	
}
