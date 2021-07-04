package programs;

 class A {
	 int a=10;
	public void show() {
		System.out.println("in parent method");
	}
}

class B extends A{
	int a=20;
	@Override
	public void show() {
		System.out.println("in child method");

	}
	
}

public class override{
	public static void main(String[] args) {
		
		A b1=new A();
		b1.show();   //in parent method
		System.out.println(b1.a); //10
		
		B b2=new B();
		b2.show();   //in child method
		System.out.println(b2.a); //20
		
		A b=new B();
		b.show();   //in child method
		System.out.println(b.a); //10
}
	
}