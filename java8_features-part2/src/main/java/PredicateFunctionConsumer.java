import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//program to display grade if only marks are about 60
class Student1{
    String name;
    int marks;

    public Student1(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}


public class PredicateFunctionConsumer {
    public static void main(String[] args){
        ArrayList<Student> l=new ArrayList<>();
        populate(l);
        Predicate<Student> p=s->s.marks>=60;
        Function<Student,String> f= s->{
            String grade=s.marks>=80?"A":(s.marks>=60?"B":(s.marks>=50?"C":(s.marks>=35?"D":"E")));
            return  grade;
        };
        Consumer<Student> c=s->{
            System.out.println("Student information: name= "+s.name+", marks= "+s.marks+"grade= "+f.apply(s));
        };
        for (Student e:l){
            if(p.test(e))
                c.accept(e);
        }
    }

    private static void populate(ArrayList<Student> l) {
        l.add(new Student("Sunny",10));
        l.add(new Student("Bunnny",65));
        l.add(new Student("Chinny",55));
        l.add(new Student("Vinny",45));
        l.add(new Student("Pinny",25));
    }
}

