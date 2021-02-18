package com.algorithms.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    
    Map<Integer,Integer> table;

    Fibonacci(){
        table = new HashMap<>();

        table.put(0,1);
        table.put(1,1);
    }

    //top-down approach aka Memoization
    public int solve(int n){
        if(!table.containsKey(n)){
            table.put(n,solve(n-1)+solve(n-2));
        }
        return table.get(n);
    }

    //botton-up approach aka tabulation.

    public void solveTabulation(int n){
        for(int i=2;i<n;i++){
            //table.put()
        }
    }


}