import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamss {
    public static void main(String[] args) {
        ArrayList<Integer> a= new ArrayList<>();
        a.add(0);
        a.add(5);
        a.add(15);
        a.add(20);
        a.add(25);
        System.out.println(a);

        //filter()
        List even=a.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println("even numbers: "+even);

        //map()
        List square=a.stream().map(i->i*i).collect(Collectors.toList());
        System.out.println("square of numbers: "+square);

        //sorted()
        //for natural sorting
        List natural=a.stream().sorted().collect(Collectors.toList());
        System.out.println("natual sorting: "+natural);

        //for custom(desc) sorting
        //List custom=a.stream().sorted((i1,i2)->i2.compareTo(i1)).collect(Collectors.toList());
        List custom=a.stream().sorted((i1,i2)->-i1.compareTo(i2)).collect(Collectors.toList());
        System.out.println("custom sorting: "+custom);

        //count()
        Long numbers=a.stream().count();
        System.out.println("numbers: "+numbers);

        //min()
        Integer minimum=a.stream().min((i1,i2)->-i1.compareTo(i2)).get();
        System.out.println("minimum number: "+minimum);

        //max()
        Integer maximum=a.stream().max((i1,i2)->-i1.compareTo(i2)).get();
        System.out.println("maximum number: "+maximum);

        //foreach()
        a.stream().forEach(System.out::println);

        //toArray()
        Integer[] array=a.stream().toArray(Integer[]::new);
        for(Integer in:array){
            System.out.println(in);
        }

        //Stream.of() for values
        Stream<Integer> str=Stream.of(9,99,999);
        str.forEach(System.out::println);

        //Stream.of() for array
        Integer[] ii={1,2,3,4,5};
        Stream<Integer> str1=Stream.of(ii);
        str1.forEach(System.out::println);

    }
}
