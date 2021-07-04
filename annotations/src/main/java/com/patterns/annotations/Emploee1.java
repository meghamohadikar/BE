package com.patterns.annotations;

import org.springframework.beans.factory.annotation.Qualifier;

public class Emploee1 implements Emp {
	
	private int id;
	private String name;
	private String dept;
	
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String fetchRecords() {
		// TODO Auto-generated method stub
		return "fetched from Employee1";
	}

}
