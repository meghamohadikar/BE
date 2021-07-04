package com.practice.examples;

import java.util.stream.Stream;

public class foreachVSforeachordered {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("a", "b", "c", "1", "2", "3");
        s.parallel().forEach(x -> System.out.println(x));

        System.out.println("-----------------");
        Stream<String> s1 = Stream.of("a", "b", "c", "1", "2", "3");
        // keep order, it is always a,b,c,1,2,3
        s1.parallel().forEachOrdered(x -> System.out.println(x));

    }
}
