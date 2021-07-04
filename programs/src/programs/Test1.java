package programs;


class First 
{ 
    int i = 10; 
   
    public First(int j) //20
    { 
        System.out.println(i);  //10
        this.i = j * 10; //200
    } 
} 
   
class Second extends First 
{ 
    public Second(int j) 
    { 
        super(j);  
        System.out.println(i);  //200
        this.i = j * 20; //400
    } 
} 
   
public class Test1 
{ 
    public static void main(String[] args) 
    { 
        Second n = new Second(20);  
        System.out.println("i="+n.i); //400
    } 
} 