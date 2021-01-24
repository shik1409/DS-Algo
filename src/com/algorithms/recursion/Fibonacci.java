package com.algorithms.recursion;

public class Fibonacci {
    
    public int head(int n){
        
        //Step-1: base condition.
        if(n==1 || n==0) return n;

        //Step-2:- have recursive call to the same fucntion.
        int result1 = head(n-1);
        int result2 = head(n-2);

        //Step-3:- do the operation on above result;
        return result1+result2;
    }

    //to create a tail recursion we need to remove interdependency of fucntions.
    //basically do everythng in a fucntion call and shudn't wait for another fucntion result.
    public int tail(int n, int accumulator){

        //Step-1: base condition.
        if(n==1) return accumulator;

        //Step-2:- recursive call using n-1 and accumulator.
        return tail(n-1,n+accumulator);
    }

    public int tail2(int n, int a, int b){
        if(n==0) return a;
        if(n==1) return b;

        return tail2(n-1,b,a+b);
    }
}