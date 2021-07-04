package com.practice.examples;

import java.util.function.Predicate;

public class PredicateJoining {
    public static void main(String[] args) {
        int[]x={0,5,10,15,20,25,30};
        //predicate to check number is greater than 10 or not
        Predicate<Integer> p1= i->i>10;
        //predicate to check number is even or not
        Predicate<Integer> p2= i->i%2==0;
        System.out.println("TheNumbersGreaterThan10:");
        m1(p1,x);
        System.out.println("TheEvenNumbersAre:");
        m1(p2,x);
        System.out.println("TheNumbersNotGreaterThan10:");
        m1(p1.negate(),x);
        System.out.println("TheNonEvenNumbersAre:");
        m1(p2.negate(),x);
        System.out.println("TheNumbersGreaterThan10AndEvenAre:");
        m1(p1.and(p2),x);
        System.out.println("TheNumbersGreaterThan10OREven:");
        m1(p1.or(p2),x);
    }

    public static void m1(Predicate<Integer> p,int[]x){
        for(int x1:x) {
            if (p.test(x1))
                System.out.println(x1);
        }
    }
}


