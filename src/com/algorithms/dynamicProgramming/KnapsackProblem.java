package com.algorithms.dynamicProgramming;

//combinatorial optimization
//usually while applying contraints...financial constraints

//this is 0-1 knapsack probllem
//subproblems:- considering every possible combination of REMAINING items and REMAINING weights.
//knapsackTable[i][w] = solution to subproblem considering first i items and w available weight.

//Simple approach: 2options for each item:
//1.) don't take the item so we have to consider our solution with previous items i.e. knapsackTable[i-1][w]
//2.) take the item so we will increment the value with item value but need to decrement the total weight i.e. v + knapsackTable[i-1][w-wi]
public class KnapsackProblem {
    
    private int numberofItems;
    private int maxCapacity;
    private int[] values;
    private int[] weights;
    private int[][] knapsackTable;

    public KnapsackProblem(int numberofItems,int maxCap,int[] values, int[] weights){
        this.numberofItems = numberofItems;
        this.maxCapacity = maxCap;
        this.values = values;
        this.weights = weights;
        this.knapsackTable = new int[numberofItems+1][maxCapacity+1];
    }

    public int finalValue(){

        for(int i=1;i<=numberofItems;i++){
            for(int w=1;w<=maxCapacity;w++){

                //i-1 means taking less than i items that is when a new item is not included.
                //each cell corresponds to the value that is coming up after including i itesm which
                // in turn fills up w weight.
                //
                int notincluded = knapsackTable[i-1][w]; // not taking item i

                int included=0;

                // here i means taking total i items in knapsack.
                // w corresponds to the weight that needs to be filled in.
                //that's why below we are just comparing the weights[i] with w as
                //that is the weight remaining to be filled and the incoming item.
                //should not be more than remaining capacity.

                if(weights[i]<=w){
                    //taking ith item means adding its value to the 
                    //profit coming from i-1 and reduced weight knapsack array.
                    included = values[i]+knapsackTable[i-1][w-weights[i]]; // taking the i items.
                }

                //items at each cell is evaluated based on maximization of the profit.
                //the final max profit value demos that whether the item has been inlcuded or not.
                //if same as i-1 not included otherwise included.
                knapsackTable[i][w] = Math.max(notincluded,included);

            }
        }

        //this is the final cell that will have max profit for the included items.
        return knapsackTable[numberofItems][maxCapacity];
    }

    public void printTable(){
        for(int i=0;i<=numberofItems;i++){
            for(int w=0;w<=maxCapacity;w++){
                System.out.print(knapsackTable[i][w]+" ");
            }
            System.out.println("");
        }
    }

    public void itemsUsed(){

    }

}