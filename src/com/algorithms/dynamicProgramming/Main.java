package com.algorithms.dynamicProgramming;

public class Main {
    
    public static void main(String[] args){
       // solveKnapsackProb();
        solveRodCutting();
       // solveSubSetProb();
    }


    private static void solveKnapsackProb(){
        int numberOfItems =3;
        int maxCapacity = 5;

        int[] weights = new int[numberOfItems+1];
        weights[1] = 4;
        weights[2] = 2;
        weights[3] = 3;

        int[] values = new int[numberOfItems+1];
        values[1] = 10;
        values[2] = 4;
        values[3] = 7;

        KnapsackProblem kp = new KnapsackProblem(numberOfItems,maxCapacity,values,weights);

        System.out.println(kp.finalValue());

        kp.printTable();
    }

    private static void  solveRodCutting(){

        int rodLength = 5;
        int[] allowedLengths = {0,1,2,3,4,5};
        int[] cutsCost = {0,2,5,7,3,9};

        RodCuttingProblem rp = new RodCuttingProblem(rodLength, cutsCost, allowedLengths);

        System.out.println(rp.numberOfCuts());

        rp.printMatrix();
        rp.printPiecesUsed();
        rp.optimalPeiceDisplay();
    }

    private static void solveSubSetProb(){

        int sum =9;
        int[] allowed = {0,5,2,1,3};

        SubsetSumProb sp = new SubsetSumProb(sum, allowed);

        sp.solve();
        sp.printMatrix();
        sp.printElements();
    }


}