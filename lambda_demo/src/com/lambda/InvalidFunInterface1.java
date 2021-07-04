package com.lambda;

@FunctionalInterface
public interface InvalidFunInterface1 {
 //not valid because having more than one abstract method
public void method1();//by default,abstract

public void method2();//by default,abstract

}