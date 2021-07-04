package com.patterns.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test  {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//Singleton singleton1=new Singleton();
		Singleton singleton1=Singleton.getInstance();
		//Singleton singleton2=Singleton.getInstance();
		//System.out.println(singleton1==singleton2);
		
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("C:/Users/mmohadik/Documents/workspace-sts-3.9.11.RELEASE/Singleton/Singleton.ser")));
		oos.writeObject(singleton1);
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("C:/Users/mmohadik/Documents/workspace-sts-3.9.11.RELEASE/Singleton/Singleton.ser")));
		Singleton singleton2=(Singleton) ois.readObject();
		oos.close();
		ois.close();
		System.out.println(singleton1==singleton2); //having different instances after serialized and then deserialized

	}

}