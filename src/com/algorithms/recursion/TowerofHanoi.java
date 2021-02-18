package com.algorithms.recursion;

/**
 * Problem:-
 * consists of multiple disks of varying sizes and 3 rods.
 * disks are arranged in ascending size on one tower at the start.
 * min no of moves req = 2^n -1 = o(2^n)
 * 
 */
public class TowerofHanoi {

    public void solve(int disk, char source, char middle, char dest)
        {
            if(disk==0){
                System.out.println("Moved "+disk+" from "+source+" to "+dest);
                return;
            }

            //now we move n-1 plates to the middle rod.
            //so that we can move largest plate to the destination rod.
            solve(disk-1,source, dest, middle);

            //we now move largest plate from source to dest rod.
            System.out.println("Moved "+disk+" from "+source+" to "+dest);

            //we move n-1 plates from middle to dest with help of source rod as auxillary rod.
            solve(disk-1,middle,source,dest);
        }
}