package com.practice.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StringToHex {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "java", "python");
        Stream<String> stream = Stream.of("abc", "java", "python");

        Consumer<String> printStringToHex = str->{
            StringBuilder sb = new StringBuilder();
            for(Character c : str.toCharArray()){
                sb.append(Integer.toHexString(c));
            }
            System.out.println("StringToHex :: "+sb);
        };

        list.forEach(printStringToHex);
        System.out.println("-----------");
        stream.forEach(printStringToHex);
    }
}
