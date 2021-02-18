package com.algorithms.selection;

import java.util.Random;

public class QuickSelect {

    private int[] nums;

    QuickSelect(int[] arr){
        this.nums = arr;
    }

    public int selectSmallest(int k){
        if(k>nums.length){
            System.out.println("Out of bounds requirement");
            System.exit(0);
        }
        return selectSmallest(0,nums.length-1,k-1);
    }

    private int partition(int indexFirst, int indexLast){
        Random r = new Random();
        int pivot = r.nextInt(indexLast-indexFirst) + indexFirst;
        swap(pivot,indexLast);

        for(int i=0;i<indexLast;i++){
            if(nums[i]<nums[indexLast]){
                swap(i,indexFirst);
                indexFirst++;
            }
        }
        swap(indexFirst,indexLast);
        return indexFirst;
    }

    private int selectSmallest(int indexFirst,int indexLast, int k){
        int pivot = partition(indexFirst,indexLast);

        
        if(pivot<k){
            //discard left sub-array.
            pivot = selectSmallest(pivot+1, indexLast, k);
        }
        else if(pivot>k){
            //discard right sub=array.
            pivot = selectSmallest(indexFirst, pivot-1, k);
        }

        return nums[pivot];
    }

    private void swap(int idx1,int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}