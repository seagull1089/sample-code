package com.implementations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by aragipindi on 3/31/15.
 */
public class CoinChange {

    public static  int getNumberOfWaysToGetChange(int nCents,int[] denominations){
        if(nCents == 0){
            return 0;
        }else {
            return changeHelper(nCents, denominations,denominations.length);
        }
    }


    public static int changeHelper(int nCents,int[] denominations,int useDenominationsUpToIndex) {
        if ((useDenominationsUpToIndex <= 0 && nCents > 0) || nCents < 0) {
            return 0;
        } else if (nCents == 0) {
            return 1;
        }else if(useDenominationsUpToIndex == 0 && nCents%denominations[0] ==0){
            return 1;
        } else {
            return changeHelper(nCents - denominations[useDenominationsUpToIndex - 1],
                    denominations, useDenominationsUpToIndex)
                    + changeHelper(nCents, denominations, useDenominationsUpToIndex - 1);
        }
    }


    public static int minCoinsForChange(int nCents, int []values,int[] mem){
        if(mem[nCents] >= 0){
            return mem[nCents];
        }
        for(int v:values){
            if(v <= nCents){
                int minCoins = minCoinsForChange(nCents -v,values,mem);
                if(mem[nCents] < 0 || minCoins +1 < mem[nCents]){
                    mem[nCents] = minCoins +1;
                }
            }
        }
        return mem[nCents];
    }


    public static void main(String[] args){
       // System.out.println(getNumberOfWaysToGetChange(4,new int[]{1,2,3}));
        int x = 65;
        int[] mem = new int[x+1];
        for(int i=0;i< mem.length; i++){
          mem[i] = -1;
        }
        mem[0]=0;

       System.out.println(minCoinsForChange(x,new int[]{1,2,5},mem));
       for(int v:mem){
            System.out.print(v);
            System.out.print(",");

        }
        System.out.println("");
    }
}
