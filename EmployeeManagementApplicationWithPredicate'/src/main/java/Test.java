import java.util.ArrayList;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        populate(list);
        Predicate<Employee> p= emp->emp.designation.equals("Manager");
        System.out.println("Managers Information:");
        display(p,list);
        Predicate<Employee> p2=emp->emp.city.equals("Bangalore");
        System.out.println("Bangalore Employees Information:");
        display(p2,list);
        Predicate<Employee> p3=emp->emp.salary<20000;
        System.out.println("Employees whose slaray <20000 To Give Increment:");
        display(p3,list);
        System.out.println("All Managers from Bangalore city for Pink Slip:");
        display(p.and(p2),list);
        System.out.println("Employees Information who are either Managers or salary <2000 0");
        display(p.or(p3),list);
        System.out.println("All Employees Information who are not managers:");
        display(p.negate(),list);
       //public static Predicate isEqual(){}
        Predicate<Employee> isCEO=Predicate.isEqual(new Employee("Durga","CEO",30000,"Hyderabad"));
        Employee e1=new Employee("Durga","CEO",30000,"Hyderabad");
        Employee e2=new Employee("Sunny","Manager",20000,"Hyderabad");
        System.out.println(isCEO.test(e1));//true
        System.out.println(isCEO.test(e2));//false
    }

    public static void populate(ArrayList<Employee> list) {
        list.add(new Employee("Durga","CEO",30000,"Hyderabad"));
        list.add(new Employee("Sunny","Manager",20000,"Hyderabad"));
        list.add(new Employee("Mallika","Manager",20000,"Bangalore"));
        list.add(new Employee("Kareena","Lead",15000,"Hyderabad"));
        list.add(new Employee("Katrina","Lead",15000,"Bangalore"));
        list.add(new Employee("Anushka","Developer",10000,"Hyderabad"));
        list.add(new Employee("Kanushka","Developer",10000,"Hyderabad"));
        list.add(new Employee("Sowmya","Developer",10000,"Bangalore"));
    }

    public static void display(Predicate<Employee> p,ArrayList<Employee> list) {
        for (Employee e: list ){
            if(p.test(e)){
               System.out.println(e);
            }
        }
        System.out.println("**************************************************");
    }
}