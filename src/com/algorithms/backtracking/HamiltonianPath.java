package com.algorithms.backtracking;

public class HamiltonianPath {
    
    private int numberOfVertices;
    private int[][] adjacencyMatrix;
    private int[][] solutionMatrix;

    HamiltonianPath(int[][] adjacencyMatrix){
        this.adjacencyMatrix = adjacencyMatrix;
        this.numberOfVertices = adjacencyMatrix.length;
        this.solutionMatrix = new int[numberOfVertices][numberOfVertices];
    }

    public void solve(){

    }

    public void printMatrix(){
        
    }

}