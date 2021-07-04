package com.patterns.abstractfactory;

public class XMLEmpDao implements DAO {

	@Override
	public void save() {
		System.out.println("saving emp to xml");

	}

}
