package com.implementations;

/**
 * Created by aragipindi on 4/10/15.
 */
public class RiverCrossing {
    /*
    X~~~~~~~~~~~~~~~~~~~~~_______($)
    *****  *   * * *  *  *
            011 2  3   4   4  3  3  3

    Initial location: 0
    Initial speed: 0

    each step:
            1. choose a new speed from {speed, speed + 1, speed - 1} (but not negative)
            2. move speed spaces: loc += speed
    3. if I land on water, I fail
    4. if I land past end of river, I win
    5. otherwise, keep going

    q - Whether there is a path from 0 to end?
//
            0 to N
    ith position
    can I reach to the ith position from any of the 0 to i-1 positions which has land.
            -- track the successful speed that can bring you to the ith position.

    */

    public static boolean canCrossRiver(String terrain){


        return false;
    }

    public static void main(String[] args){

    }
}
