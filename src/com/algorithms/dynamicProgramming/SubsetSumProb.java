package com.algorithms.dynamicProgramming;

//given a subset of given array can we find a sub-array where elements of subarray element value sum results
//to certain predefined value;
//
public class SubsetSumProb {
    
    //final sum that shud be the result.
    private int finalSum;
    //actual list of integers to be considered.
    private int[] allowedVal;
    //matrix for solution.
    private boolean[][] subsetMatrix;


    SubsetSumProb(int finalVal,int[] allowed){
        this.finalSum = finalVal;
        this.allowedVal = allowed;
        this.subsetMatrix = new boolean[allowedVal.length][finalVal+1];
    }

    //What should be rows and columns count
    //rows = output(number of elements included)
    //columns = constraint(keep incrementing the number by 1)
    public void solve(){

        for(int i=0;i<allowedVal.length;i++){
            for(int j=0;j<=finalSum;j++){
                subsetMatrix[i][j] =  solvePart(i,j,allowedVal);                        
            }
        }

        System.out.println("The final output is: "+subsetMatrix[allowedVal.length-1][finalSum]);

    }

    private boolean solvePart(int index, int Sum, int[] allowed){
        if(allowed[index]==Sum)
            return true;       
        if(Sum==0) return true;

        if(index>0){
            // As a sum is true with earlier integers adding more elements doesn't matter.
            if(subsetMatrix[index-1][Sum]) return true;

            //if the previous elements failed to achieve the sum then lets evaluate with current integer.
            if(Sum - allowed[index]>0){
                return solvePart(index-1, Sum - allowed[index], allowed);
            }
        }
        return false;
    }

    public void printMatrix(){
        for(int i=0;i<allowedVal.length;i++){
            for(int j=0;j<=finalSum;j++){
                System.out.print(subsetMatrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public void printElements(){

        for(int i=allowedVal.length-1,j=finalSum;i>0;){
           // System.out.println(i+" "+j);
            if(subsetMatrix[i][j] != subsetMatrix[i-1][j]){
                System.out.println("Used element: "+allowedVal[i]);
                j=j-allowedVal[i];
                i--;
            }
            else{i--;}
        }

    }

}