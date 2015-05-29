package com.implementations;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by aragipindi on 4/27/15.
 */
public class TreeMapTest {
    public static void main(String[] args){
        TreeMap<Double,Character> mmap = new TreeMap<>();
        mmap.put(0.0d,'A');
        mmap.put(0.1d,'B');
        mmap.put(0.2d,'C');
        mmap.put(0.3d,'D');
        mmap.put(0.9d, 'E');
        mmap.put(0.99d, 'F');
        mmap.put(0.995d, 'G');
        System.out.println(mmap.floorEntry(0.9999d));
        System.out.println(mmap.floorEntry(0.1576d));
        int[] test = new int[]{5, 4, 10, 15, 7, 9, 10};
        System.out.println(Arrays.toString(mergeSort(test)));
        //System.out.println(Arrays.toString(merge(new int[]{1,2,3},new int[]{4,5,6})));
    }

    public static int[] merge(int[] first,int[] second){
        int i = 0, j= 0,k=0;
        int[] merged = new int[first.length + second.length];
        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                merged[k++] = first[i++];
            }else{
                merged[k++] = second[j++];
            }
        }
        while(i < first.length){
            merged[k++] = first[i++];
        }
        while(j < second.length){
            merged[k++] = second[j++];
        }
        return merged;
    }

    public static int[] mergeSort(int[] array){
        if(array.length == 1){
            return array;
        }

        int mid = array.length/2;
        int[] first = mergeSort(Arrays.copyOfRange(array,0,mid));
        int[] second = mergeSort(Arrays.copyOfRange(array,mid ,array.length));
        return merge(first,second);

    }
}
