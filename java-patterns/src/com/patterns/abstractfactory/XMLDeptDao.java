package com.patterns.abstractfactory;

public class XMLDeptDao implements DAO {

	@Override
	public void save() {
		System.out.println("saving dept to xml");

	}

}
