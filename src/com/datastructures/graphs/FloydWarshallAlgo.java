package com.datastructures.graphs;

public class FloydWarshallAlgo {

    private int[][] adjacencyMatrix;
    private int length;
    private int[][] finalGraph;

    FloydWarshallAlgo(int[][] graph){
        this.adjacencyMatrix = graph;
        this.length = adjacencyMatrix.length;
        this.finalGraph = graph;
    }

    public void solve(){

        int[][] intermediaryGraph = new int[length][length];

        for(int k=0;k<length;k++){
            for(int i=0;i<length;i++){
                for(int j=0;j<length;j++){
                    if(i==k || j==k){
                        intermediaryGraph[i][j] = finalGraph[i][j];
                        continue;
                    }

                    int prevDist = finalGraph[i][j];
                    int newDist = finalGraph[i][k]+finalGraph[k][j];

                    intermediaryGraph[i][j] = Math.min(prevDist, newDist);

                }
            }

            finalGraph = intermediaryGraph;
        }

        printSol();

    }

    public void printSol(){
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                System.out.print(finalGraph[i][j]);
            }
            System.out.println("");
        }
    }
    
}