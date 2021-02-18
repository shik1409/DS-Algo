package com.algorithms.backtracking;

public class Main {

    public static void main(String[] args){

        //QueensProblem qp = new QueensProblem(5);
        //qp.solve();
        //solveColors();
        solveMaze();
    }

    private static void solveColors(){

        int[][] graphMatric = new int[][]{
            {0,1,0,1,0},
            {1,0,1,1,0},
            {0,1,0,1,0},
            {1,1,1,0,1},
            {0,0,0,1,0}
        };

        int numberofColors = 3;

        ColoringProblem cp = new ColoringProblem(graphMatric, numberofColors);

        cp.solve();
    }

    private static void solveMaze(){
        int maze[][] = {{1,1,0,0},
                        {1,1,0,1},
                        {1,1,0,1},
                        {0,1,1,1}};
        
        RatInMaze rm = new RatInMaze(maze);

        rm.solve();
    }
    
}