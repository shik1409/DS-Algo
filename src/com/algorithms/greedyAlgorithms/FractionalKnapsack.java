package com.algorithms.greedyAlgorithms;

import java.util.Collections;
import java.util.PriorityQueue;

public class FractionalKnapsack {
    
    private Item[] items;
    private int maxWeight;
    private PriorityQueue<Item> pq;

    FractionalKnapsack(int maxWeight, int[] weights, int[] values){
        this.maxWeight = maxWeight;
        items = new Item[weights.length];
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<weights.length;i++){
            items[i] = new Item(weights[i], values[i],i);
            pq.add(items[i]);
        }
    }

    public int solve(){

        int result = 0;
        int weight = maxWeight;

        while(weight>0){
            Item taking = pq.peek();
            if(taking ==null) break;
            pq.poll();
            int itmWt = taking.getWeight();
            if(weight>=itmWt){
                result = result+taking.getPrice();
                weight = weight-itmWt;
            }
            else{
                result = result + (int)Math.round((taking.getRatio()*(itmWt-weight)));
                weight = 0;
            }
        }
        return result;
    }


    private static class Item implements Comparable<Item>{
        private int weight;
        private int value;
        private double ratio;
        private int idx;

        Item(int weight,int value, int idx){
            this.weight = weight;
            this.value = value;
            this.ratio = Double.valueOf(value/weight);
            this.idx = idx;
        }

        public double getRatio(){
            return ratio;
        }

        public int getWeight(){
            return weight;
        }

        public int getPrice(){
            return this.value;
        }

        public int getIndex(){
            return this.idx;
        }

        @Override
        public int compareTo(Item i){
            if(this.getRatio() < i.getRatio()){
                return -1;
            }
            else if(this.getRatio() > i.getRatio()){
                return 1;
            }
            return 0;
        }
    }

}

