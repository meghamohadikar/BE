package com.patterns.abstractfactory;

public class DBDeptDao implements DAO {

	@Override
	public void save() {
		System.out.println("saving dept to DB");

	}

}
