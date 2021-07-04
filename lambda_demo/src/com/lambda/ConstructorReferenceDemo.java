package com.lambda;

public class ConstructorReferenceDemo {


	public static void main(String[] args) {
		Details d = Student :: new;
		Student s = d.getStudent("Meenal");
	}
}

class Student{
	Student(String name){
		System.out.println(name +" is successfully enrolled!");
	}
}

interface Details{
	public Student getStudent(String name);
}
