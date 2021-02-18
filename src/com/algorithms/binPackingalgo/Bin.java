package com.algorithms.binPackingalgo;

import java.util.ArrayList;
import java.util.List;

public class Bin {
    
    private int capacity;
    private int id;
    private int capacityLeft;
    private int itemsCount;
    private List<Integer> items;

    Bin(int capacity, int id){
        this.capacity = capacity;
        this.id = id;
        this.capacityLeft = capacity;
        this.itemsCount = 0;
        items = new ArrayList<>();
    }

    public boolean addItem(int itemSize){
        if(itemSize>capacityLeft)
            return false;

        items.add(itemSize);
        itemsCount++;
        capacityLeft = capacityLeft-itemSize;

        return true;
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("Bin : "id+" has "+ this.itemsCount+" items following entities: ");

        for(int item:items){
            sb.append(item+" ");
        }

        return sb.toString();
    }
}