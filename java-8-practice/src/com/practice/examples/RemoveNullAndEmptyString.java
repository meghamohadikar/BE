package com.company;

import java.util.ArrayList;
import java.util.function.Predicate;

public class RemoveNullAndEmptyString {
    public static void main(String[] args) {
        String[] names = {"Sunny", "Kajal", "", null, "Mallika", "Katrina", "Kareena"};
        //Predicate<String> s=a->a.length()!=0 && a!=null; gives NPE
        Predicate<String> s=a-> a!=null && a.length()!=0;
        ArrayList<String> list=new ArrayList<>();
        for(String name:names){
            if(s.test(name))
                list.add(name);
        }
        System.out.println(list);

    }
}
