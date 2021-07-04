package com.core.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	   static Logger log = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
 
		
		//BeanFactory context = new XmlBeanFactory(new FileSystemResource("Beans.xml"));
		      //ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml"); //loads beans configuration file,creates spring container to store the beans and initialize the objects(beans) 
	      AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      	log.info("Going to create HelloWord Obj");
	      	HelloWorld obj =  (HelloWorld) context.getBean("helloWorld"); //gets the required bean of particular id provided in Beans.xml
		       obj.getMessage();
		       //obj.age=15;
		       System.out.println(obj.age);
		       obj.test();
		       
		       HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
		       objB.getMessage();
		       objB.getMessage2();
		       objB.getMessage3();
		
		       context.registerShutdownHook(); //only applicable in context of AbstractApplicationContext 
		       log.info("Exiting the program");


	}

}
