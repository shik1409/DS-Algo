package com.algorithms.backtracking;

//device a tour throughout the board to cover all he cells exactly once.
public class KnightsMoveProblem {
    
    private int[][] maze;
    private int[][] solution;
    private int[] rowMoves = {2,2,-2,-2,1,1,-1,-1};
    private int[] colMoves = {1,-1,1,-1,2,-2,2,-2;

    private int mazeSize;

    KnightsMoveProblem(int[][] maze){
        this.maze = maze;
        this.mazeSize = maze.length;
        this.solution = new int[mazeSize][mazeSize];
    }

    public void printSolution(){
        for(int i=0;i<mazeSize;i++){
            for(int j=0;j<mazeSize;j++){
                if(solMatrix[i][j]==1){
                    System.out.println("s");
                }
                else{
                    System.out.println("-");
                }
            }
        }
    }

    public void solve(int x,int y){

        if(solveMaze(x,y)){
            printSolution();
        }
        else{
            System.out.println("No Solution");
        }
        

    }

    private void solveMaze(int x,int y){

    }

    private boolean isValid(){

        return false;
    }
}