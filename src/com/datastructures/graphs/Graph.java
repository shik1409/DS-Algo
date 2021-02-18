package com.datastructures.graphs;

public class Graph {
    
    class Edge{
        int start;
        int end;
        int cost;

        Edge(int start,int end,int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        Edge(){
            start=end=cost=0;
        }
    }

    int vertices,edges;
    Edge edge[];

    Graph(int v, int e){
        this.vertices = v;
        this.edges = e;
        edge = new Edge[e];

        for(int i=0;i<e;i++){
            edge[i] = new Edge();
        }
    }

    

}