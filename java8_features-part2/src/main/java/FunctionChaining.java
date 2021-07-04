import java.util.function.Function;

public class FunctionChaining {
    public static void main(String[] args){
        Function<String,String> f1=s->s.toUpperCase();
        Function<String,String> f2=s->s.substring(0,9);
        //first apply f1 ,then f2
        System.out.println(f1.andThen(f2).apply("MeghaMohadikar"));
        //first apply f2 ,then f1
        System.out.println(f1.compose(f2).apply("MeghaMohadikar"));
    }
}
