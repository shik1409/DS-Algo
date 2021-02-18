package com.algorithms.backtracking;


//4 parts
//a.) Choices.
//b.)COntraints
//c.) Recursion and backtracking
//d.) goal
public class RatInMaze {

    private int[][] maze;
    private int[][] solution;
    private int mazeSize;

    RatInMaze(int[][] maze){
        this.maze = maze;
        this.mazeSize = maze.length;
        this.solution = new int[mazeSize][mazeSize];
    }

    //Main backtracking logic goes here.
    //rememeber the reason we are not passing maze and solutionmaze to the below fucntion is
    //we created this method as part of the class which already has these 2 objects as variables.
    //using them in recursive call we are able to solve the entire question.
    public void solve(){
        if(solutionRecursion(0,0)){
            printSol();
        }
        else{
            System.out.println("No Solution");
        }
    }

    private boolean solutionRecursion(int x,int y){

        //Goal.
        if(x==mazeSize-1 && y==mazeSize-1 && maze[x][y]==1){
            solution[x][y] = 1;
            return true;
        }

         //constraint.
         if(isSafe(x,y)){
            solution[x][y] = 1;


            //recursion
            if(solutionRecursion(x+1,y))
                return true;

            if(solutionRecursion(x,y+1))
                return true;

            //backtracking if above not satisfied.
            solution[x][y] = 0;
            return false;
        }

        //if constraint not satisfied then return false;
        return false;
        /*
        for(int i=x;i<mazeSize;i++){
            for(int j=y;j<mazeSize;j++){
                if(isSafe(i,j)){
                    solution[i][j] = 1;

                    if(isSafe(i+1,j) || isSafe(i, j+1)){
                        continue;
                    }

                    solution[i][j] = 0;

                }

            }
        }
        */
    }

    //printing the solution matrix.
    private void printSol(){
        for(int i=0;i<mazeSize;i++){
            for(int j=0;j<mazeSize;j++){
                System.out.print(solution[i][j]);
            }
            System.out.println("");
        }
    }

    //Constraint - Oviously applied using he original maze here.
    private boolean isSafe(int x, int y){
        return (x>=0 && x<mazeSize && y>=0 && y<mazeSize && maze[x][y]==1);
    }
    
}