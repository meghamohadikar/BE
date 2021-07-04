class Sample{
    Sample(){
        System.out.println("sample constructor execution and object creation");
    }
}
interface Interf1{
    public Sample get();
}
public class ConstructorReference {
    public static void main(String[] args) {
        //with lambda expression
        Interf1 i=()->new Sample();
        Sample s=i.get();
        //with constructor reference
        Interf1 i1=Sample::new;
        Sample s1=i1.get();
    }
}
