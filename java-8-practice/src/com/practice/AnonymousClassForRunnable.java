package com.practice;

public class AnonymousClassForRunnable {
    public static void main(String[] args) {
        //anonymous inner class
       Runnable m = new Runnable() {
           @Override
           public void run() {
               System.out.println("in run method");
           }
       };

        Thread t = new Thread(m);
        t.start();
    }
}
