package com.practice.practice;

import java.util.*;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
        list.add(new Hosting(6, "linode.com", 100000)); // new line

        // key = id, value - websites
        //Map<Integer, String> result1 = list.stream().collect(Collectors.toMap(Hosting::getId, Hosting::getName));
        //System.out.println("Result 1 : " + result1);

        // key = name, value - websites
        Map<String, Long> result2 = list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites,(oldValue,newValue)->newValue));
        System.out.println("Result 2 : " + result2);

        // Same with result1, just different syntax
        //Map<Integer, String> result3 = list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));
        //System.out.println("Result 3 : " + result3);

        Map result4 = list.stream()
                .sorted(Comparator.comparingLong(Hosting::getWebsites).reversed()) //remove reversed() for ascending order
                .collect(
                        Collectors.toMap(
                                Hosting::getName, Hosting::getWebsites, // key = name, value = websites
                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
                        ));

        System.out.println("Result 4 : " + result4);
    }
}
