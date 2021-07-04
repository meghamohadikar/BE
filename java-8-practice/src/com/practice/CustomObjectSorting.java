package com.practice;

import java.util.ArrayList;
import java.util.Collections;

public class CustomObjectSorting {
    public static void main(String[] args){
        ArrayList<Employee> e=new ArrayList<>();
        e.add(new Employee(200,"Deepika"));
        e.add(new Employee(400,"Sunny"));
        e.add(new Employee(100,"Mallika"));
        e.add(new Employee(100,"Katrina"));
        System.out.println("Before sorting= "+e);

        //custom(ascending) sorting of eno with lambda expression
        Collections.sort(e,(o1, o2)->(o1.eno<o2.eno)?-1:((o1.eno>o2.eno)?1:0)
        );
        System.out.println("After custom(ascending) sorting= "+e);

        //custom(descending) sorting of eno with lambda expression
        Collections.sort(e,(o1, o2)->(o1.eno>o2.eno)?-1:((o1.eno<o2.eno)?1:0)
        );
        System.out.println("After custom(descending) sorting= "+e);
    }
}
