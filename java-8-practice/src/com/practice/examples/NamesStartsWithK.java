package com.practice.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class NamesStartsWithK {
    public static void main(String[] args){
        String[] names={"Sunny","Kajal","Mallika","Katrina","Kareena"};
        List<String> namesList = Arrays.asList(names);

        Predicate<String> s=str->str.startsWith("K");

        for(String name:names){
            if(s.test(name))
                System.out.println(name);
        }
        System.out.println("----------------------------------");

        namesList.stream().filter(s).forEach(System.out::println);

        System.out.println("----------------------------------");

        //to check if collection is empty or not
        Predicate<Collection> c= a->a.isEmpty();
        ArrayList array=new ArrayList();
        System.out.println(c.test(array));

    }
}
