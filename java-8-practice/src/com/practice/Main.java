package com.practice;

public class Main {//implements Runnable{
    /*@Override
    public void run() {
        System.out.println("in run method");
    }*/

    public static void main(String[] args) {
        Runnable m = ()-> System.out.println("in run method");
        //Main m = new Main();
        //Thread t = new Thread(m);
        Thread t = new Thread(()-> System.out.println("in run method of thread"));
        t.start();
    }
}
