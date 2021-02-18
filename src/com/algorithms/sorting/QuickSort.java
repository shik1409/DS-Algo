package com.algorithms.sorting;
import java.util.Random;

public class QuickSort {

    private int[] nums;

    QuickSort(int[] arr){
        this.nums = arr;
    }

    public int[] sortDesc(){
        sortDesc(0,nums.length-1);
        return nums;
    }

    private void sortDesc(int indexFirst,int indexLast){
        if(indexFirst>= indexLast)
            return;
        int pivot = partition(indexFirst, indexLast);
        sortDesc(indexFirst,pivot-1);
        sortDesc(pivot+1,indexLast);
    }

    private int partition(int indexFirst, int indexLast){
        int pivot = new Random().nextInt(indexLast - indexFirst)+indexFirst;
        swap(pivot,indexLast);

        for(int i=indexFirst;i<indexLast;i++){
            if(nums[i]<nums[indexLast]){
                swap(i,indexFirst);
                indexFirst++;
            }
        }

        swap(indexFirst,indexLast);
        System.out.println(indexFirst+" "+nums[indexFirst]);
        return pivot;
    }

    private void swap(int idx1,int idx2){
        int temp = nums[idx2];
        nums[idx2] = nums[idx1];
        nums[idx1] = temp;
    }
    
}