import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

class Employee{
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class PredicateAndFunction {
    public static void main(String[] args){
        ArrayList<Employee> l=new ArrayList<>();
        populate(l);
        Predicate<Employee> p=e->e.salary<3500;
        Function<Employee,Employee> f=e->{
            e.salary=e.salary+477;
            return e;
        };
        for (Employee emp:l) {
            if(p.test(emp)){
                System.out.println(f.apply(emp));
            }
        }
    }

    private static void populate(ArrayList<Employee> l) {
        l.add(new Employee("Sunny",1000));
        l.add(new Employee("Bunny",2000));
        l.add(new Employee("Chinny",3000));
        l.add(new Employee("Pinny",4000));
        l.add(new Employee("Vinny",5000));
        l.add(new Employee("Durga",10000));

    }
}
