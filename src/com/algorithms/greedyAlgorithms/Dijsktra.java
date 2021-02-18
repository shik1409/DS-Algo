package com.algorithms.greedyAlgorithms;

public class Dijsktra {

    private int[][] adjacencyMatrix;
    private int length;
    private int[] distances;
    private int[] visitedNodes;

    Dijsktra(int[][] adjacencyMatrix){
        this.adjacencyMatrix = adjacencyMatrix;
        this.length = adjacencyMatrix.length;
        this.distances = new int[length];
        this.visitedNodes = new int[length];

        //initialize a new array having inifinite distances among vertices.
        for(int i=0;i<length;i++){
            distances[i] = Integer.MAX_VALUE;
        }
    }

    public void solve(){

        //make the first vertex as starting point and hence a visited vertex.
        //so all the distances are right now being measured from this vertex.
        distances[0] = 0;

        //Loop over each node for exploration.
        for(int i=0;i<length;i++){

            //get the vertex which has minimum distance froms starting vertex and has not been touched so far.
            //we target first the nearest vertex as that is the best cadidate for the shortest path.
            //at starting this will return the starting vertex itself.
            int minVertex = minVertex(distances,visitedNodes);

            //now after finding the min vertex make it visited vertex as it wil be used below for evaluation.
            visitedNodes[minVertex] = 1;

            //loop over all vertices as we are going to find distance from this visited vertex to all connected vertices.
            for(int j=0;j<length;j++){

                //if a vertex is visited no need to conitnue;
                if(visitedNodes[j]==1){
                    continue;
                }
                if(adjacencyMatrix[minVertex][j]==0)
                    continue;
                
                //dstance between 2 vertices added to the min distance stored in the distance array gives
                //total distance from the starting vertex.
                int newdist = distances[minVertex] + adjacencyMatrix[minVertex][j];

                //if now the distance between the new vertex and starting is lesser than old distance
                //update the distance to this new vertex with the new value.
                if(distances[j]<newdist)
                    continue;
                
                distances[j] = newdist;
            }
        }
        printSol();
    }

    private void printSol(){
        for(int i=0;i<length;i++){
            System.out.println(distances[i]);
        }
    }

    //returns vertex with minimum distance from array distance 
    //rememeber the araray consisist of distance from ref point i.e. the starting point.
    //hence min returned is min distance from starting point.
    //at start the starting vertex will be returned
    //and as the distances gets updated further nodes will be returned.
    private int minVertex(int[] distances,int[] visited){
        int minVertex = -1;

        for(int i=0;i<distances.length;i++){
            if(visited[i]==0 && (minVertex==-1 || distances[i]<distances[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }
}