package com.practice.examples;

import java.util.Objects;
import java.util.TreeSet;

public class TreeSetSorting {
    public static void main(String[] args){
        TreeSet<Integer> t=new TreeSet<>();
        t.add(10);
        t.add(0);
        t.add(15);
        t.add(5);
        t.add(20);
        System.out.println("natural sorting= "+t);

        TreeSet<Integer> t1=new TreeSet<>((o1,o2)->(o1>o2)?-1:((o1<o2)?1:0));
        t1.add(10);
        t1.add(0);
        t1.add(15);
        t1.add(5);
        t1.add(20);
        System.out.println("Custom sorting= "+t1);

        t1.stream().filter(Objects::nonNull).forEach(System.out::println);
    }

}

