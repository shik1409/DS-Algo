package com.datastructures.graphs;

import java.util.Arrays;

public class PrimsAlgo {

    private int[][] adjacencymatrix;
    private int length;
    private boolean[] selected;
    private int edges;
    private int minCost;

    PrimsAlgo(int[][] graph){
        this.adjacencymatrix = graph;
        this.length = adjacencymatrix.length;
        this.selected = new boolean[length];
        Arrays.fill(selected, false);
        edges=0;
        minCost = 0;
    }

    public void getMST(){
        selected[0] = true;
        //keep looping till we have all edges for mst.
        while(edges<length-1){
            mstSubProb();
        }

        System.out.println("minCost is: "+minCost);
    }

    private void mstSubProb(){
        int minEdge = Integer.MAX_VALUE;
        int x = 0, y=0;

        //loop over all the vertices in the graph.
        for(int i=0;i<length;i++){

            //check if present vertice is already selcted or not.
            if(selected[i]){

                //if selected loop again on all vertices to get the weight of edge.
                for(int j=0;j<length;j++){

                    //if selected no need to see for any edge as its part of mst
                    if(selected[j])
                        continue;
                    int dist = adjacencymatrix[i][j];

                    //if no connection present leave it.
                    if(dist==0)
                        continue;
                    
                    //if the edge is of lower cost than variable select this edge.
                    if(minEdge>dist){
                        minEdge = dist;
                        x = i;
                        y = j;
                    }
                }
            }
        }

        //here we are done looping on all the selected nodes in MST to select next min cost edge
        //so do rest of operations.
        selected[y] = true;
        System.out.println(x+"-"+y+" : "+minEdge);
        edges++;
        minCost = minCost+minEdge;
    }
    
}