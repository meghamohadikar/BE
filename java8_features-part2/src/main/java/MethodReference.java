interface Interf{
    public void m1();
}
public class MethodReference {
    public static void m2(){
        System.out.println("Static Method reference");
    }
    public static void main(String[] args) {
        Interf i=MethodReference::m2;
        i.m1();
    }
}
