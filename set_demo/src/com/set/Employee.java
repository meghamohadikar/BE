package com.set;

public class Employee implements Comparable {

	private String name;
	private int salary;

	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
