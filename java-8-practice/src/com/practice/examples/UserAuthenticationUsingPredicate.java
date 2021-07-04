package com.company;

import java.util.Scanner;
import java.util.function.Predicate;

class User {
    String username;
    String pwd;

    User(String username,String pwd){
        this.username=username;
        this.pwd=pwd;
    }
}

public class UserAuthenticationUsingPredicate {
    public static void main(String[] args){
        Predicate<User> u=a->a.username.equals("mmohadik") && a.pwd.equals("Megha@1997");
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter User Name:");
        String username=sc.next();
        System.out.println("Enter Password:");
        String pwd=sc.next();
        User user=new User(username,pwd);
        if(u.test(user)){
            System.out.println("Valid user and can avail all services");
        } else {
            System.out.println("invalid user you cannot avail services");
        }
    }
}


