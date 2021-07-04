
//javac StaicTest.java Static.java //to compile
//java StaicTest //to run
public class Static {

	
	public void Test2()
	{
		System.out.println("test2");
	}
	
	public static void Test()
	{
		System.out.println("in static class");
	}
	
	public void Test1(Object o)
	{
		
		System.out.println("test1 with object=="+o);
		
	}
	

	/*public void Test1(String s)
	{
		
		System.out.println("test1 with String=="+s);
		
	}*/
	

	public void Test1(Integer s)
	{
		
		System.out.println("test1 with Integer=="+s);
		
	}
}
