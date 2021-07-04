

public class StaicTest extends Static {

	
	
	public static void Test()
	{
		System.out.println("in StaicTest class");
	}
	

	public void Test2()
	{
		System.out.println("test2 in StaticTest");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StaicTest t= new StaicTest();
		StaicTest.Test();
		
		/*Static t2= new StaicTest ();
		t2.Test();
		t2.Test2();*/
		
		
		t.Test1("mahesh");
		t.Test1(12);
		t.Test1(null);//.The String is a subclass of Object and therefore its method is called.
		
		Test();
		
		
		
		
		
		
	}

}
