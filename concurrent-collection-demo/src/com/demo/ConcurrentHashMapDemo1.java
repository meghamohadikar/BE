package com.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo1 extends Thread{
static ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<Integer,String>();
//static HashMap<Integer,String> map = new HashMap<Integer,String>();

	public static void main(String[] args) {
		map.put(1,"John");
		map.put(2,"Rohn");
		map.put(3,"Tom");
		map.put(4,"Shiva");
		
		System.out.println(map);
		
		
		Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();
		
		ConcurrentHashMapDemo1 tChild = new ConcurrentHashMapDemo1();
		tChild.start();
		
		while(itr.hasNext()) {
			Entry<Integer, String> entry = itr.next();
			System.out.println("Key = "+entry.getKey()+" Value = "+entry.getValue());
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void run() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put(5,"Ganesha");
		
	}
}
