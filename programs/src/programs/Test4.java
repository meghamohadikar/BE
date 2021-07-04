package programs;

class One implements Runnable  
{ 
    public void run()  
    { 
        System.out.print(Thread.currentThread().getName()); 
    } 
} 
class Two implements Runnable  
{ 
    public void run()  
    { 
        new One().run(); 
        new Thread(new One(),"gfg2").run(); //since a new thread can be created by calling start 
        									//method only so the previous thread does the action and again gfg1 is printed
        new Thread(new One(),"gfg3").start(); 
    } 
} 
class Test4  
{ 
    public static void main (String[] args)  
    { 
        new Thread(new Two(),"gfg1").start(); 
    } 
} 
