public class RunnableWithMethodReference {
    public void m1(){
        for(int i=0;i<10;i++){
            System.out.println("child thread");
        }
    }

    public static void main(String[] args) {
        RunnableWithMethodReference obj=new RunnableWithMethodReference();
        Runnable r =obj::m1;
        Thread t=new Thread(r);
        t.start();

    }
}
