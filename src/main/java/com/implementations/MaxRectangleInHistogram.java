package com.implementations;

import java.util.Arrays;


/**
 * Created by aragipindi on 4/8/15.
 */
public class MaxRectangleInHistogram {
    public static int getMaxRectangle(int[] bars){
        int[] maxAreas = new int[bars.length];
        for(int i =0 ; i < bars.length ; i++){
            maxAreas[i] =  bars[i];
            int min_height = bars[i];
            for(int j = i-1; j >=0; j--){
                if(bars[j] < min_height){
                    min_height = bars[j];
                }
                int maxAreaPossible = min_height*(i-j+1);
                maxAreas[i] = Math.max(maxAreaPossible,maxAreas[i]);
            }
        }
        return Arrays.stream(maxAreas).max().orElse(0);
    }

    public static void main(String[] args){
        System.out.println(getMaxRectangle(new int[]{1,2,3,0,4,5,6}));
        System.out.println(getMaxRectangle(new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(getMaxRectangle(new int[]{1,1,1,1,0,1,1,1}));
        System.out.println(getMaxRectangle(new int[]{}));
    }

}
