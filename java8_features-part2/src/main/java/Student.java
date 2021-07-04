import java.util.ArrayList;
import java.util.function.Function;

public class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

class Test{
    public static void main(String[] args){
        ArrayList<Student> l=new ArrayList<>();
        populate(l);
        Function<Student,String> f=s->{
            String grade=s.marks>=80?"A":(s.marks>=60?"B":(s.marks>=50?"C":(s.marks>=35?"D":"E")));
            return  grade;
        };
        for (Student e:l){
            System.out.println(f.apply(e));
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
