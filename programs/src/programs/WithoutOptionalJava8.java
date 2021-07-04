package programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WithoutOptionalJava8 {
	public static void main(String[] args)
	{
		List<Employee> employeeList = createEmployeeList();
		Employee employee = findEmployee(employeeList,"John");
		System.out.println("Employee name: "+employee.getName());
	}
	
	public static Employee findEmployee(List<Employee> employeeList,String name)
	{
		for(Employee e:employeeList)
		{
			if(e.getName().equalsIgnoreCase(name))
			{
				return e;
			}
		}
		return null;
	}
	public static List<Employee> createEmployeeList()
	{
		List<Employee> employeeList=new ArrayList<>();
		
		Employee e1=new Employee("John",21);
		Employee e2=new Employee("Martin",22);
		Employee e3=new Employee("Mary",31);
		Employee e4=new Employee("Stephan",18);
		Employee e5=new Employee("Gary",26);
		
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.add(e5);
		
		Set<Integer> ages=employeeList.stream().map(x->x.getAge()).collect(Collectors.toSet());
		System.out.println("list of ages="+ages);
		return employeeList;
		
	}
}