import java.util.function.Function;

public class FunctionFunctionalInterface {
    public static void main(String[] args){
        Function<String,String> f= a->a.replaceAll(" ","");
        System.out.println(f.apply("Megha Mohadikar"));

        //find number of whitespaces
        Function<String,Integer>  f1=a->a.length()-a.replaceAll(" ","").length();
        System.out.println(f1.apply("Megha Mohadikar "));

    }
}