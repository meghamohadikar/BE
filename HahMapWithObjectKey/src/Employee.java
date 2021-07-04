import java.math.BigDecimal;
import java.util.Date;

//make this class as immutable as hashcode needs not to be changed 
public final class Employee {    
	private final long id;    
	private final String name;    
	private final Date dateOfBirth;    
	private final BigDecimal salary;
	
	public Employee(long id, String name, Date dateOfBirth, BigDecimal salary) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public BigDecimal getSalary() {
		return salary;
	}
	@Override
	public boolean equals(Object o) {
		System.out.println("in equals");
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
			if (id != employee.id) return false;
			if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
			if (dateOfBirth != null ? !dateOfBirth.equals(employee.dateOfBirth) : employee.dateOfBirth != null) return false;
	return salary != null ? salary.equals(employee.salary) : employee.salary == null;
		}
	
	@Override
	public int hashCode() {
		System.out.println("in hashcode");

		int result = 31;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
		result = 31 * result + (salary != null ? salary.hashCode() : 0);
	return result;
	    }
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + "]";
	} 
	
	
}