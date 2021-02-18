package com.algorithms.sorting;

public class Main {

    public static void main(String[] args){
        int[] testArr = new int[]{1,-4,-7,0,2,7,200,-3,7};
        QuickSort qs = new QuickSort(testArr);
        int[] resArr = qs.sortDesc();
        for(int i : resArr){
            System.out.print(i+" ");
        }
    }
}