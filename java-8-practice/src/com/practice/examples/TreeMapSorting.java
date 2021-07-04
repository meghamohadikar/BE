package com.practice.examples;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapSorting {
   public static void main(String[] args){
      TreeMap<Integer,String> t=new TreeMap<>();
      t.put(100,"Durga");
      t.put(600,"Sunny");
      t.put(300,"Bunny");
      t.put(200,"Chinny");
      t.put(700,"Vinny");
      t.put(100,"Pinny");//overwrite duplicate keys
      System.out.println("natual sorting of keys= "+t);

      //custom sorting of keys
      TreeMap<Integer,String> t1=new TreeMap<>((o1,o2)->(o1>o2)?-1:((o1<o2)?1:0));
      t1.put(100,"Durga");
      t1.put(600,"Sunny");
      t1.put(300,"Bunny");
      t1.put(200,"Chinny");
      t1.put(700,"Vinny");
      t1.put(100,"Pinny");
      System.out.println("custom sorting of keys= "+t1);

      for(Map.Entry<Integer,String> entry : t1.entrySet()){
         System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
      }
      t1.forEach((k,v)->System.out.println("Key : " + k + ", Value : " + v));
   }
}


