package com.datastructures.graphs;

public class Main {
    
    public static void main(String[] args){
        primAlgo();
    }

    private static void primAlgo(){
        int graph[][] = {
            {0,3,0,0,8},
            {3,0,4,2,0},
            {0,4,0,10,0},
            {0,2,10,11,0},
            {8,0,0,11,0}
        };

        PrimsAlgo pa = new PrimsAlgo(graph);
        pa.getMST();
    }
}