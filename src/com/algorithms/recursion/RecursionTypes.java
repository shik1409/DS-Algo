package com.algorithms.recursion;

public class RecursionTypes {

    public static void head(int n){
        
        System.out.println("Calling the function with n = "+n);

        if(n==0) return;

        //we call the method recursively.
        head(n-1);

        //we do some operation.
        //operation = Sysout()
        System.out.println("The value of n= "+n);
    }


    public static void tail(int n){
        
        System.out.println("Calling the function with n = "+n);

        if(n==0) return;

        //we do some operation.
        //operation = Sysout()
        System.out.println("The value of n= "+n);

        //we call the method recursively.
        tail(n-1);
    }
    
}