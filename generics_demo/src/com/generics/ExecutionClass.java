package com.generics;

public class ExecutionClass {
	
	public static void main(String... args) {

		GenericDAO<Employee> employeeDao = new GenericDAO<Employee>();
		Employee newEmployee = new Employee();
		employeeDao.saveToDB(newEmployee);
		Employee oldEmployee = employeeDao.getDetails(250);
		GenericDAO<Inventory> inventoryDao = new GenericDAO<Inventory>();
		Inventory newInventory = new Inventory();
		inventoryDao.saveToDB(newInventory);
		Inventory oldInventory = inventoryDao.getDetails(100);

		int[] x = new int[2];
		int[] a = x;
		x[1] = 1;
		System.out.println(a[1]);
		System.out.println(x[1]);
		a[0] = 1;
		System.out.println(a[0]);
		System.out.println(x[0]);
	}


}
