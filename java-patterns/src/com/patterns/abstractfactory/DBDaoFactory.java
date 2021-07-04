package com.patterns.abstractfactory;

public class DBDaoFactory extends DAOAbstractFactory {

	@Override
	public DAO createDAO(String type) {
		DAO d=null;
		if(type.equals("emp"))
			d=new DBEmpDao();
		else if(type.equals("dept"))
			d=new DBDeptDao();
		return d;
	}

}
