package com.implementations;

/**
 * Created by aragipindi on 3/31/15.
 */
public class SubSequences {

    public static int longestIncreasingSubSequence(int[] numbers){
        int[] mem = new int[numbers.length];
        for(int i = 0; i < mem.length; i++){
            mem[i] = 1;
        }
        int max = 0;
        for(int i = 0; i < mem.length; i++){
            for(int j = 0; j < i; j++){
                if(numbers[j] <= numbers[i] && mem[j] +1 > mem[i]){
                    mem[i] = mem[j]+1;
                    if(mem[i] > max){
                        max = mem[i];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(longestIncreasingSubSequence(new int[]{5, 3, 4, 8, 6, 7}));
    }
}
