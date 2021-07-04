import java.util.function.Function;

public class IdentityMethod {
    public static void main(String[] args){
        //T and R should be same
        Function<String,String>f=Function.identity();
        String s2=f.apply("Durga");
        System.out.println(s2);
    }
}
