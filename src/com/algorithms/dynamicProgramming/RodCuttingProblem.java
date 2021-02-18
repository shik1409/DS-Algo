package com.algorithms.dynamicProgramming;

// almost same as knapsack logic.
public class RodCuttingProblem {
    
    private int rodlength;
    private int[] cutsCost;
    private int[] pieceLens;
    private int[][] rodCuttingMatrix;

    RodCuttingProblem(int rodLen, int[] prices, int[] allowedLens){
        this.rodlength = rodLen;
        this.cutsCost = prices;
        this.pieceLens = allowedLens;
        this.rodCuttingMatrix = new int[pieceLens.length][cutsCost.length];
    }


//While creating dpMatrix following needs to be taken care of:-
// y = output(here it is number of cuts or peices from a given length);
// x = constraint(here it is the length of the rod as need to consider what is the cost of making a cut for each length of the rod).
//each cell = cost of making a cut or a peice.
//x=0 => length of the rod is 0...so obviously it didn't cost us anything.
//y=0 => there is no cost of cutting a peice and hence it will also cost us nothing for operations.
    public int numberOfCuts(){

        for(int count=1;count<=rodlength;count++){
            for(int j=1;j<=rodlength;j++){

                //Initialize the base price of making one cut according to the rod's length.
                if(count==1){
                    rodCuttingMatrix[count][j] = j*cutsCost[count];
                    continue;
                }

                //in case we are not cutting a rod:
                // we are not going to account for cutting cost.
                // so we take the cell above with the prevous number of peices.
                //and hence the len will remain as is.
                int notCuttingCost = rodCuttingMatrix[count-1][j];

                int cuttingCost = 0;

                //need to be checked if the peice length contraint is maintained or not.
                //if it is breaking we cannot cut the rod and hence ignore.
                if(pieceLens[count] <= j){

                    //if the cut is going to be made the final o/p will be i cuts.
                    //so with i cuts calculate the cost for j-length just now cut.
                    cuttingCost = cutsCost[count] + rodCuttingMatrix[count][j - pieceLens[count]];
                }

               // System.out.println(notCuttingCost+" "+cuttingCost+" "+count+" "+j);

                rodCuttingMatrix[count][j] = Math.max(notCuttingCost,cuttingCost);

            }
        }

        return rodCuttingMatrix[rodlength][rodlength];

    }

    public void printMatrix(){
        for(int i=0;i<rodCuttingMatrix.length;i++){
            for(int j=0;j<rodCuttingMatrix.length;j++){
                System.out.print(rodCuttingMatrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public void printPiecesUsed(){

        int[] results = new int[rodCuttingMatrix.length];

        int i = rodCuttingMatrix.length-1;
        int j = rodCuttingMatrix.length-1;

        int cost = rodCuttingMatrix[i][j];

        while(cost>0){
            //System.out.println(i+" "+j+" "+cost);
            if(rodCuttingMatrix[i-1][j] == cost){
                i--;
                continue;
            }
            else{
                results[i] = results[i]+1;
                if(j-i >= 0){
                    cost = rodCuttingMatrix[i][j-i];
                    j = j-i;
                    continue;
                }
            }
        }

        for(int cuts=1;cuts<results.length;cuts++){
            System.out.println(results[cuts]+" cuts were made for "+cuts+" peices");
        }
    }


    public void optimalPeiceDisplay(){

        for(int i=pieceLens.length-1,j=rodlength;i>0;){
            if(rodCuttingMatrix[i][j]!=0 && rodCuttingMatrix[i][j] != rodCuttingMatrix[i-1][j]){
                System.out.println("We used peice of len: "+pieceLens[i]+"m");
                j = j-i;
            }
            else{
                i--;
            }
        }

    }

}