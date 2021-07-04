package com.patterns.abstractfactory;

public class DBEmpDao implements DAO {

	@Override
	public void save() {
		System.out.println("saving emp to DB");

	}

}
