package com.algorithms.recursion;

public class Factorial {

    //head creates inter-dependency between fucntion calls.
    //this creates a stack dependency to store previous function call and variables.
    public int head(int n){
        
        //1.) base condition:- factorial of 1 is 1
        if(n==1) return 1;
        // 2.) recursively call the same function: have a recursive call
        int res1 = head(n-1);
        //3.) after recursive call do the operation.
        int result = n*res1;

        return result;
    }

    //in head method calls rely heavily on each other.
    //coz if this, the call relies heavily on stack.
    //if we use an accumulator we remove the inter-dependency on the functions.
    public int tail(int n, int accumulator){
        if(n==1) return accumulator;

        return tail(n-1,n*accumulator);
    }
    
}