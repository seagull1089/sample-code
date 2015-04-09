package com.implementations;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aragipindi on 4/2/15.
 */
public class ConnectedCells {

    public int getMaxConnectedCells(int[][] array,int n,int m){
        int[][] labels = new int[n][m];
        Map<Integer,Integer> labelEquals = new HashMap();
        Map<Integer,Integer> labelCounts = new HashMap();
        int maxLabel = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(array[i][j] == 1){
                    int topRowLabel = maxLabel+1;
                    int prevColLabel = maxLabel+1;
                    if(i > 0 &&  labels[i-1][j] > 0 ) topRowLabel = labels[i-1][j];
                    if (j > 0 && labels[i][j-1] > 0)  prevColLabel = labels[i][j-1];
                    int minLabel = Math.min(topRowLabel,prevColLabel);
                    labels[i][j] = minLabel;
                    labelCounts.put(minLabel,labelCounts.getOrDefault(minLabel,0)+1);

                    if(topRowLabel > 0 && topRowLabel < maxLabel+1 && prevColLabel > 0 &&
                            prevColLabel < maxLabel+1){
                        labelEquals.put(Math.min(topRowLabel,prevColLabel),Math.max(topRowLabel,prevColLabel));
                    }

                }
            }
        }


        for(Integer key: labelCounts.keySet()){

        }
        return 0;
    }

    public static void main(String[] args){

    }
}
