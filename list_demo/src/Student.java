

public class Student implements Comparable<Student>{
	private Integer id;
	private String name;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Override
	public int compareTo(Student o) {
		return this.getId().compareTo(o.getId());
		//return this.getName().compareTo(o.getName());
		
		/*
		 * System.out.println("this.getId()"+this.getId());
		 * System.out.println("o.getId()"+o.getId());
		 * System.out.println("this.getId()-o.getId()"+(this.getId()-o.getId()));
		 * 
		 * return this.getId()-o.getId();
		 */
	}
	
	

}
