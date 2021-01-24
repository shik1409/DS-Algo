package com.algorithms.sorting;

//Stable
//O(1) extra space
//O(n2) comparisons and swaps
//Adaptive: O(n) when nearly sorted

//bubbling up the highest value to the top of the array.
public class BubbleSort {
    
    public static int[] performSort(int[] input){
        for(int i=0;i<input.length;i++){
            for(int j=i;j<input.length;j++){
                if(input[i] > input[j]){
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }

        return input;
    }

}