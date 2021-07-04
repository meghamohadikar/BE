package com.patterns.abstractfactory;

public class DAOFactoryProduer { //factory of factories
	public static DAOAbstractFactory produce(String factorytype) {
		DAOAbstractFactory daf=null;
		if(factorytype.equals("xml"))
			daf=new XMLDaoFactory();
		else if(factorytype.equals("db"))
			daf=new DBDaoFactory();
		return daf;
	}
}
