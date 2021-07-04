package com.practice;

interface Interf {
    public void m1();
}

public class AnonymousClassThisKeyword {
    int x=888; //instance var of AnonymousClassThisKeyword
    public void m2(){
        Interf i1=()->{
            int x=999;//local var
            x=777;
            System.out.println(this.x);//888
            System.out.println(x);//999
        };
        Interf i=new Interf() {
            int x=999;//instance var of anonymous iner class
            @Override
            public void m1() {
                System.out.println(this.x);//999
                System.out.println(AnonymousClassThisKeyword.this.x);//888
            }
        };
        i1.m1();
    }
}
class Main1{
    public static void main(String[] args){
        AnonymousClassThisKeyword a=new AnonymousClassThisKeyword();
        a.m2();
    }
}



