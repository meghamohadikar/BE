package com.practice;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSorting {
    public static void main(String[] args){
        ArrayList<Integer> l= new ArrayList<>();
        l.add(10);
        l.add(0);
        l.add(15);
        l.add(5);
        l.add(20);
        System.out.println("Before sorting= "+l);

        //natural sorting
        Collections.sort(l);
        System.out.println("After natural sorting= "+l);

        //custom sorting without lambda expression
        //MyComparator c=new MyComparator();
        //Collections.sort(l, c);

        //custom sorting with lambda expression
        Collections.sort(l,(o1,o2)->(o1>o2)?-1:((o1<o2)?1:0)
        );
        System.out.println("After custom sorting= "+l);

    }
}
