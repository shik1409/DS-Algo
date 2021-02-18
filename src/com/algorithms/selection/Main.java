package com.algorithms.selection;

public class Main {

    public static void main(String[] args){
        int[] testArr = new int[]{3,-2,5,8,1,6,0,9};

        QuickSelect qs = new QuickSelect(testArr);

        System.out.println(qs.selectSmallest(11));
    }
    
}