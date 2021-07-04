import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.ToIntFunction;

public class PrimitivePredicate {
    public static void main(String[] args) {
        int[] x ={0,5,10,15,20,25};
        IntPredicate p= i->i%2==0;//LongPredicate,DoublePredicate
        for (int x1 : x) {
            if(p.test(x1))
                System.out.println(x1);
        }
        IntFunction<Integer> f= i->i*i;
        System.out.println(f.apply(5));
        ToIntFunction<String> f1=s->s.length();
        System.out.println(f1.applyAsInt("Durga"));
        IntToDoubleFunction f2=i->Math.sqrt(i);
        System.out.println(f2.applyAsDouble(76));

    }
}
