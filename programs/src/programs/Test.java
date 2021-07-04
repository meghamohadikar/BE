package programs;

public  class Test {
    boolean [] b = new boolean[3];
    int count = 0;

    void set(boolean [] x, int i) 
    {
        x[i] = true;
        ++count;
    }

    public static void main(String [] args) 
    {
    	Test ba = new Test();
        ba.set(ba.b, 0);
        ba.set(ba.b, 2);
        ba.test();
        String a="abc";
        String a1=new String("abc");
        a=a1;
        //a1=a;
        if(a==a1) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    void test() 
    {
    	
        if ( b[0] && b[1] | b[2] )
            count++;
        if ( b[1] && b[(++count - 2)] )
            count += 7;
        System.out.println("count = " + count);
    }
   
}