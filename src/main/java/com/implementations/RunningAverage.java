package com.implementations;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * Created by aragipindi on 3/22/15.
 */
public class RunningAverage {

    private  final int N;
    private  final Queue<Integer> runningQueue;
    private int runningSum = 0;
    public RunningAverage(int N){
        this.N = N;
        this.runningQueue = new LinkedList<Integer>();
    }


    public int getRunningAverage(int x){
        if(runningQueue.size() == N){
            int head = runningQueue.remove();
            runningSum += x;
            runningSum -= head;
            runningQueue.add(x);
            return (runningSum)/N;
        }else{
            return 0;
        }
    }


    public void main(String args[]){
        RunningAverage ravg  = new RunningAverage(10);


    }
}

interface SomethingIsWrong {
    /*default void aMethod(int aValue){
        System.out.println("Hi Mom");
    }
    */
}

class MyCharSequence implements CharSequence{


    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
