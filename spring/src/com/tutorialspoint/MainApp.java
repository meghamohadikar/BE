package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.xml.XmlBeanFactory; 
import org.springframework.core.io.ClassPathResource;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainApp {
   public static void main(String[] args) {
	  //XmlBeanFactory context = new XmlBeanFactory (new ClassPathResource("Beans.xml")); 
	  //ApplicationContext context = new FileSystemXmlApplicationContext("C:/Users/mmohadik/Desktop/BE/workspace-spring-tool-suite-4-4.2.0.RELEASE/spring/src/Beans.xml");
      //ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	  AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

      HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
      objA.setMessage("I'm object A");
      objA.getMessage();

      HelloWorld objB = (HelloWorld) context.getBean("helloWorld2");
      objB.getMessage();   
      context.registerShutdownHook();
      
		/*
		 * HelloWorld1 objA = (HelloWorld1) context.getBean("helloWorld1");
		 * objA.getMessage1(); objA.getMessage2();
		 * 
		 * HelloIndia objB1 = (HelloIndia) context.getBean("helloIndia1");
		 * objB1.getMessage1(); objB1.getMessage2(); objB1.getMessage3();
		 */

      }
}