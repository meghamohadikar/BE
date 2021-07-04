package com.practice.second;

//JVM will not understand which m1() method to execute in case of multipleInheritance with Default method,i.e from Left or Right
//we can solve this problem in two ways-1. By overriding m1() method.2. By calling interface_name.super.m1();
public class DataAmbiguity implements Left,Right{
    @Override
    public void m1() {
        //System.out.println("child default method");
        Left.super.m1();
    }
    public static void main(String[] args){
        DataAmbiguity d=new DataAmbiguity();
        d.m1();

    }
}
