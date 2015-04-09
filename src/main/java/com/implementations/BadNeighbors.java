package com.implementations;

import java.util.Arrays;

/**
 * Created by aragipindi on 4/1/15.
 * http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
 *
 * { 10, 3, 2, 5, 7, 8 }
 Returns: 19

 { 11, 15 }
 Returns: 15


 { 7, 7, 7, 7, 7, 7, 7 }
 Returns: 21
 */
public class BadNeighbors {

    public static int getMaxDonationsPossible(int[] amounts){
        if(amounts.length==0){
            return 0;
        }
        int[] maxDonations = Arrays.copyOf(amounts, amounts.length);
        boolean[] hasTheFirstPersonDonated = new boolean[amounts.length];

        for(int i = 0; i < amounts.length; i++){
            for(int j = 0; j < i -1; j++){
                if( (i != amounts.length-1 || (i== amounts.length-1 && !hasTheFirstPersonDonated[j])) &&
                        maxDonations[j] + amounts[i] > maxDonations[i]){
                    maxDonations[i] = maxDonations[j] + amounts[i];
                    hasTheFirstPersonDonated[i] = (j==0 || hasTheFirstPersonDonated[j]);
                }
            }
        }

        return Arrays.stream(maxDonations).max().orElse(0);

    }

    public static void main(String[] args){
        System.out.println(getMaxDonationsPossible(new int[]{ 10, 3, 2, 5, 7, 8 }));
        System.out.println(getMaxDonationsPossible(new int[]{ 11, 15 }));
        System.out.println(getMaxDonationsPossible(new int[]{ 7, 7, 7, 7, 7, 7, 7 }));
    }
}
