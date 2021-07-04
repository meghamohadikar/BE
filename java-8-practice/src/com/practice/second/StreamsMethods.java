package com.practice.second;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsMethods {
    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person result1 = persons.stream()
                .filter((p) -> "jack".equals(p.getName()) && 20 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println("result 1 :" + result1);

        String name = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String
                .findAny()
                .orElse("");

        System.out.println("name : " + name);

        List<String> collect = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);


    }
}
