package com.algorithms.recursion;

public class Main {
    
    public static void main(String[] args){
        System.out.println("Starting Head");
        RecursionTypes.head(4);
        System.out.println("Starting Tail");
        RecursionTypes.tail(4);

        System.out.println("");
        Factorial fact = new Factorial();
        System.out.println(fact.head(12));
        System.out.println(fact.tail(12,1));

        System.out.println("");
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.head(10));
        System.out.println(fib.tail(10,1));

        System.out.println("Towers of Hanoi");
        TowerofHanoi TOH = new TowerofHanoi();
        TOH.solve(2, 'A', 'B', 'C');
    }
}