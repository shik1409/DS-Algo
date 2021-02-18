package com.algorithms.backtracking;

public class QueensProblem {
    private int[][] chessBoard;
    private int numberOfQueens;

    public QueensProblem(int numOfQueens){
        this.chessBoard = new int[numOfQueens][numOfQueens];
        this.numberOfQueens = numOfQueens;
    }

    public void solve(){
        if(setQueens(0)){
            printQueens();
        }
        else{
            System.out.println("No Solution");
        }
    }

    private boolean setQueens(int colIndex){

        //Goal
        if(colIndex==numberOfQueens){
            return true;
        }

        for(int i=0;i<numberOfQueens;i++){

            //containt using isPlaceValid function.
            if(isPlaceValid(i, colIndex)){
                chessBoard[i][colIndex] = 1;

                //recusrion by increasing column index
                if(setQueens(colIndex+1)){
                    return true;
                }

                //if above is flase then we need to backtrack now.
                //Backtracking
                chessBoard[i][colIndex]=0;

                //System.out.println(i+" "+colIndex+" "+chessBoard[i][colIndex]);
            }
        }
        return false;
    }

    private boolean isPlaceValid(int rowIndex,int colIndex){

        //evaluating per column basis so only need to check till current column.
        for(int i=0;i<colIndex;i++){
            //System.out.println(i+" "+colIndex);
            if(chessBoard[rowIndex][i]==1)
                return false;
        }

        //now - diagonals
        //One-diagonal travel starting from queen till below diagonal
        for(int i=rowIndex,j=colIndex; i< numberOfQueens && j>=0;i++,j--){
           //System.out.println(i+" "+j);
            if(chessBoard[i][j]==1)
                return false;
        }

        //one-diagonal starting from queen till above diagonal
        for(int i=rowIndex,j=colIndex; i>=0 && j>=0; i--,j--){
            if(chessBoard[i][j]==1)
                return false;
        }

        return true;
    }

    public void printQueens(){
        for(int i=0;i<numberOfQueens;i++){
            for(int j=0;j<numberOfQueens;j++){
                if(chessBoard[i][j]==1){
                    System.out.print("*");
                }
                else{
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
    }
}