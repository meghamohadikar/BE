package com.JPAapp.JPAapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main( String[] args ) {
    	
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
    	EntityManager em=emf.createEntityManager();
    	Student s=em.find(Student.class,1); //to fetch the record
    	
    	System.out.println(s);
    	
    	Student a=new Student();
    	a.setRollno(4);
    	a.setName("arvind");
    	a.setMarks(30);
    	
    	em.getTransaction().begin(); //start the transaction to save
    	em.persist(a); //to save 
    	em.getTransaction().commit();
    }
}
