package com.lambda;

import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
		int salary = 3000;
		boolean result = salaryCheck(salary); //without Predicate
		System.out.println(result);

		Employee employee=new Employee();
		Predicate<Integer> p = i -> i>=4000;  //with Predicate
		boolean result1 = p.test( salary);
		System.out.println(result1);
	}

	private static boolean salaryCheck(int salary) {
		// TODO Auto-generated method stub
		if(salary>=4000)
			return true;
		return false;
	}

}
