package com.algorithms.backtracking;


//Steps for backtracking
//Constructor
//
public class ColoringProblem {

    private int numberOfVertices;
    private int colorNumbers;
    private int[] vertexColors;
    private int[][] adjacencymatrix;
    //private int[] vertexArray;

    ColoringProblem(int[][] adjacencymatrix, int colorsAllowed){
        this.numberOfVertices = adjacencymatrix.length;
        this.colorNumbers = colorsAllowed;

        this.vertexColors = new int[numberOfVertices];
        this.adjacencymatrix = adjacencymatrix;
    }

    public void solve(){

        //Recursive function call with starting condition
        //if true returned print solution
        //else print no solution.
        if(solveColor(0)){
            printSolution();
        }
        else{
            System.out.println("No Solution");
        }
    }

    //This will always be boolean
    //params are most important as they define every recursion call.
    private boolean solveColor(int colorVertex){

        //System.out.println(colorVertex+" "+numberOfVertices);
        //base condition to return true when done.
        //the condition value here will become a parameter.
        if(colorVertex == numberOfVertices){
            return true;
        }

        //Loop here to backtrack.
        //loop on ...
        for(int colorUsed=1;colorUsed<=colorNumbers ;colorUsed++){
            //when condition to evaluate whether the present condition is valid or not.
            //if valid set required values in the matrix or array to store data.
            if(isValid(colorVertex,colorUsed)){
                vertexColors[colorVertex] = colorUsed;

                //recursive call here always.
                solveColor(colorVertex+1);

                //if above returned true...meaning we were successfull in all below iterations.
                //so retunr true
                return true;
            }

            //here backtracks happen always.
            //reset if in step following isValid is setting property on a 
            //variable that is dependent on a variable used in loop.
            //as in next ietartion the variable will be lost and hence reset here only.

            //as colorvertex is not used in loop.
            //it will be definitely rest in next iteration.
        }
        return false;
    }

    //validity check function
    private boolean isValid(int colorVertex, int colorUsed) {

        //System.out.println(colorVertex+" isvalid "+colorUsed);
        for(int i=0;i<numberOfVertices;i++){
            if(adjacencymatrix[colorVertex][i] == 1 && vertexColors[i] == colorUsed){
                return false;
            }
        }

        return true;
    }

    private void printSolution() {
        for(int i=0;i<numberOfVertices;i++){
            System.out.println("Color used for node: "+i+" is "+vertexColors[i]);
        }
    }
}