package programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WithOptionalJava8 {
	public static void main(String[] args)
	{
		//orElseGet is lazy counter part of orElse.It takes supplier as parameter and will be called only if value is not present in Optional.
		List<Employee> employeeList = createEmployeeList();
		Optional<Employee> employeeOpt1 = findEmployee(employeeList,"Adam");
		System.out.println("employeeOpt1="+employeeOpt1);
		
		Employee employee1 = employeeOpt1.orElse(new Employee("Dummy",0));
		Employee employee3 = employeeOpt1.orElseGet(()->new Employee("Dummy1",0));
		//Employee employee4 = employeeOpt1.orElseThrow(() -> new RuntimeException("Employee not found"));
		System.out.println("Employee name: "+employee3.getName());
		
		Optional<Employee> employeeOpt2 = findEmployee(employeeList,"Martin");
		Employee employee2= employeeOpt2.orElse(new Employee("Dummy",0));
		System.out.println("Employee name: "+employee2.getName());
		
		employeeOpt1.ifPresent((employee)->System.out.println("Employee name: "+employee.getName()+" found in list"));
		employeeOpt2.ifPresent((employee)->System.out.println("Employee name: "+employee.getName()+" found in list"));
		if(employeeOpt1.isPresent())
		{
			Employee employee = employeeOpt1.get();
			System.out.println("Employee name: "+employee.getName());
		}
		else
		{
			System.out.println("There is no employee with name Adam");
		}
	}
	
public static Optional<Employee> findEmployee(List<Employee> employeeList,String name)
{
	for(Employee e:employeeList)
	{
		if(e.getName().equalsIgnoreCase(name))
		{
			return Optional.of(e);
		}
	}
	return Optional.empty();
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
		
		return employeeList;
		
	}
}