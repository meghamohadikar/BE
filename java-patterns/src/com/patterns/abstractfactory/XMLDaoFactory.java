package com.patterns.abstractfactory;

public class XMLDaoFactory extends DAOAbstractFactory {

	@Override
	public DAO createDAO(String type) {
		DAO d=null;
		if(type.equals("emp"))
			d=new XMLEmpDao();
		else if(type.equals("dept"))
			d=new XMLDeptDao();
		return d;
	}

}