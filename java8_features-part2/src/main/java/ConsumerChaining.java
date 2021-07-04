import java.util.ArrayList;
import java.util.function.Consumer;

public class ConsumerChaining {
    public static void main(String[] args) {
        Consumer<String> c1=c-> System.out.println("Wake up "+c);
        Consumer<String> c2=c-> System.out.println("Toothbrush "+c);
        Consumer<String> c3=c-> System.out.println("Have Breakfast "+c);

        Consumer<String> chainedC=c1.andThen(c2).andThen(c3);
        chainedC.accept("Megha");
    }
}
