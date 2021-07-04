package programs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test6{
	public static void main(String ar[])throws Exception{
		Thread.sleep(90);
		System.out.println("test");
		int x=0,y,total = 0;
		for(x=0;x<=5;x++){ //0,1,2,3,4,5
				y=x+x; //0  2  4 6
				total+=y; //0  0+2+4+6
				
			}
			System.out.println(total);
			
			Float f[]=new Float[5];
			System.out.println(f[0]);
			Object b= f;
			System.out.println(f[0]);
			
			final int x1=-127;

			byte b1=x1; //can store -128-127


			System.out.println(b1);
			
			String s1 = "abc"; 
	        String s2 = s1; 
	        s1 += "d"; 
	        System.out.println(s1 + " " + s2 + " " + (s1 == s2)); 
	  
	        StringBuilder sb1 = new StringBuilder("abc"); 
	        StringBuilder sb2 = sb1; 
	        //StringBuffer sb1 = new StringBuffer("abc"); 
	        //StringBuffer sb2 = sb1; 
	        sb1.append("d"); 
	        System.out.println(sb1 + " " + sb2 + " " + (sb1 == sb2)); 
	        
	        //Any number beginning with zero is treated as an octal number (which is 0-7)
	        short s = 0; 
	        int x3 = 07; 
	        //int y3 = 08; //not valid octal number
	        int z = 112345; 
	  
	        s += z; 
	        //System.out.println("" + x + y3 + s); 

	        Object i = new ArrayList().iterator();  
	        System.out.println((i instanceof List) + ", ");  
	        System.out.print((i instanceof Iterator) + ", ");  
	        System.out.print(i instanceof ListIterator);  
		}
 }