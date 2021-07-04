package com.pkg;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		Laptop l=new Laptop();
		l.setLid(101);
		l.setLname("Dell");
		
		
		Student s=new  Student();
		s.setName("Megha");
		s.setRollno(1);
		s.setMarks(50);
		//s.setLaptop(l); //for one to one
		s.getLaptops().add(l); //for one to many
		
		l.getStudents().add(s); //for manytomany
		
		Configuration config=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		SessionFactory factory=config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		session.save(l);
		session.save(s);
		
		System.out.println("successfully saved");
		
		t.commit(); 
		factory.close(); 
		session.close();
		
	}

}
