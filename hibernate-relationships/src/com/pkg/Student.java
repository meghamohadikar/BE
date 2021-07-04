package com.pkg;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int rollno;
	private String name;
	private int marks;
	
	//@OneToOne  // will create one more column named laptop_lid having lid of the respective student
	//private Laptop laptop;
	
	//@OneToMany//will create another table Student_Laptop having Student_rollno and laptops_lid
	//@OneToMany(mappedBy="student") //will not create table Student_Laptop because  we are mapping it by student property of laptop  class
	@ManyToMany(mappedBy="student",fetch=FetchType.EAGER)//by default, LAZY
	private List<Laptop> laptops=new ArrayList<Laptop>();
	
	public List<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	

}
