package com.patterns.abstractfactory;

public class Test {

	public static void main(String[] args) {
		DAOAbstractFactory daf=DAOFactoryProduer.produce("db");
		DAO dao=daf.createDAO("dept");
		dao.save();
	}

}
