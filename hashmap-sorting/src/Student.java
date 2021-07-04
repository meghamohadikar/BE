

import java.util.*;
import java.util.Map.Entry;

public class Student implements Comparator<Entry<Integer,Student>>
{
	private int age;
	private int id;
	private String name;
	
	public Student() {}

	public Student(int age, int id, String name) {
		this.age = age;
		this.id = id;
		this.name = name;
	}

	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString()
	{   return "[ id=" + id + ", name=" + name + ", age=" + age + "]";
		
	}


	
	/*
	 * @Override public int compare(Student o1, Student o2) { 
	 * return o1.getName().compareTo(o2.getName());
	 * 
	 */
	
	@Override
	public int compare(Entry<Integer, Student> o1, Entry<Integer, Student> o2) {
		// TODO Auto-generated method stub
		return o1.getValue().getName().toLowerCase().compareTo(o2.getValue().getName().toLowerCase());
	}

}
