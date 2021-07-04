package com.patterns.abstractfactory;

public abstract class DAOAbstractFactory { 
	public abstract DAO createDAO(String type);

}
