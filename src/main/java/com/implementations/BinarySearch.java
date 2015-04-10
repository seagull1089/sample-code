package com.implementations;

import java.util.Arrays;

/**
 * Created by aragipindi on 4/1/15.
 */
    public class BinarySearch {

    public static int findTarget(int[] A, int target){
        int lo = 0;
        int hi = A.length;
        int mid = -1;
        mid = (hi + lo)/2;
        while(lo <= hi && mid < A.length ){

            if( target == A[mid]){
                System.out.println("Index: " + mid);
                return mid;

            }else if(target < A[ mid]){
                hi = mid -1;
            }else{
                lo = mid+1;
            }
            mid = (lo + hi)/2;
        }

        return -(mid) -1;
    }

    public static void main(String[] args){
        int[] array = new int[]{5,5,5,5,5,5,5,7,7,7,7};
        System.out.println(findTarget(array,5));
        System.out.println(Arrays.binarySearch(array, 8));
        System.out.println(findTarget(array, 8));
    }
}
