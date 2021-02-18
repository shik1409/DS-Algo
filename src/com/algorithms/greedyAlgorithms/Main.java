package com.algorithms.greedyAlgorithms;

public class Main {

    public static void main(String[] args){
       // solveKnapSack();
        solveDijsktra();
    }

    private static void solveKnapSack(){
        int[] weights=  {10,40,20,30};
        int[] values=  {60,40,100,120};
        int capacity  =50;

        FractionalKnapsack fk = new FractionalKnapsack(capacity, weights, values);
        System.out.println(fk.solve());
    }

    private static void solveDijsktra(){
        int matrix[][] = {
            {0,3,5,6,0,8,0},
            {3,0,0,4,2,0,5},
            {5,0,0,0,0,4,0},
            {6,4,0,0,0,1,6},
            {0,2,0,0,0,0,10},
            {8,0,6,1,0,0,8},
            {0,8,0,6,10,8,0}
        };

        Dijsktra dk = new Dijsktra(matrix);

        dk.solve();
    }
    
}