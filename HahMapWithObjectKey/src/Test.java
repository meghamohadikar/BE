import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {

		HashMap<Employee,String> employeeMap=new HashMap<>();
		Employee employee1 = new Employee(1,"Sachin",new Date(1987,2,1),new BigDecimal(100000));   
			employeeMap.put(employee1,"India");   
		Employee employee2 = new Employee(1,"Sachi",new Date(1987,2,1),new BigDecimal(100000));   
			employeeMap.put(employee2,"Japan");   

		for (Map.Entry<Employee, String> employeeStringEntry : employeeMap.entrySet()) {
	    	System.out.println(employeeStringEntry.getValue());   
		    	System.out.println(employeeStringEntry.getKey().hashCode());   
		 }
	}

}
