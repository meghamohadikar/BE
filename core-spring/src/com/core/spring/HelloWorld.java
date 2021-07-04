package com.core.spring;

public class HelloWorld {
	private String message;
	private String msg2;
	public int age;
	//private DependecyClass dc;
	private MainInterface mi;
	/*
	 * public HelloWorld(DependecyClass dc) { 
	 * this.dc = dc;
	 * System.out.println("Inside HelloWorld constructor." );
	 * 
	 * }
	 */

	/*
	 * public HelloWorld(String message,int age,String msg2 ) {
	 * this.message=message; this.age=age; this.msg2=msg2;
	 * 
	 * }
	 */
	public void setMessage(String message){
		   System.out.println("msg assigned");
	      this.message  = message;
	   }

	 public void getMessage(){
		 System.out.println("Your Message : " + message); 
		}
	 
	
	/*
	 * public DependecyClass getDc() { return dc; }
	 * 
	 * public void setDc(DependecyClass dc) {
	 * System.out.println("inside dc setter");
	 * 
	 * this.dc = dc; }
	 */

	 public MainInterface getMi() {
			return mi;
		}

		public void setMi(MainInterface mi) {
			this.mi = mi;
		}
		
	public void test() {
		//dc.method();
		mi.method();
	}

	

	public void init(){
	      System.out.println("Bean is going through init.");
	   }
	 
	 public void destroy() {
	      System.out.println("Bean will destroy now.");
	  }
	 

}
