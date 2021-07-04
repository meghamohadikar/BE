
public class Test {
	public static void main(String args[]){  
		final Customer c=new Customer();  
		/*
		 * Thread t1=new Thread(){ public void run(){ c.withdraw(15000); } };
		 * t1.start();
		 */
		 
		new Thread(){  
			public void run(){	
				c.withdraw(15000);
				}  
			}.start();  
			
			new Thread(){  
				public void run(){
					c.deposit(10000);
					}  
			}.start();  
		}
}
