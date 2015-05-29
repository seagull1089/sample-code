package com.implementations;

/**
 * Created by aragipindi on 4/28/15.
 */
public class UnionOfIntervals {
    public static int nthSmallest(int[] lowerBound,int[] upperBound,int rank){
        int lowerNumElements = lowerBound[1] - lowerBound[0] +1 ;
        int upperNumElements = upperBound[1] - upperBound[0] + 1;
        if(rank <= lowerNumElements){
            return lowerBound[0] + rank -1;
        }else{
            return upperBound[0] + rank - lowerNumElements  -1;
        }
    }
    public static void main(String[] args){

    }
}
