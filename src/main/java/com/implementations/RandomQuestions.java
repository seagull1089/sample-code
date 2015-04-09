package com.implementations;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Collectors;


/**
 * Created by aragipindi on 3/22/15.
 */
public final  class RandomQuestions {
    /*
     abcd
        dabc
        cdab
        bcda
        abcd
     */

    public static String rotateString(String input,int amt){
        if(input != null && input.length() > 0) {
            int rotationMod = amt % input.length();
            String partial = input.substring(input.length() - rotationMod);
            return partial + input.substring(0, input.length() - rotationMod);
        }else{
            return input;
        }
    }


    // given two sorted sets, get the difference of A-B

    public SortedSet<Integer> computeDifference(SortedSet<Integer> s1,SortedSet<Integer> s2){
        Iterator<Integer> it1 = s1.iterator();
        Iterator<Integer> it2 = s2.iterator();

        return null;
    }

    //Implement a data structure to support dynamic insertion, deletion of intervals.
    // Overlapping intervals should be merged.
    class Intervals{

    }

    //Given some input data consisting of sets of increasing numbers,
    // match patterns where the sequence of deltas between the numbers match


    // TODO:
    //1. merge two sorted lists. 2.merge k sorted lists


   // Print out the level order traversal of a Binary Tree, with new line after each level.


    //Given an input string and a target string, find the minimum substring of the input string
    //that contains all of the characters in the target string.



    //They asked to write a function that takes a string and check if it is a number.
    // The second question was given a sorted array that has been rotated, find a number in that array {6,7,1,2,3,4,5}


    // mirror a tree.


    // Find all the permutations of a string

    private static void  permutationHelper(String prefix,String rest, List<String> accumulator){
        if(rest.isEmpty()){
            accumulator.add(prefix);
        }
        for(int i = 0; i < rest.length(); i++){
            String remaining = rest.substring(0,i) + rest.substring(i+1);
            permutationHelper(prefix + rest.charAt(i), remaining, accumulator);
        }
    }
    public static List<String> getAllPermutations(String input){
        List<String> accumulator = new LinkedList<>();
        permutationHelper("",input,accumulator);
        return accumulator;
    }


    public static List<String> combinationHelper(String xs){
        List<String> accumulator = new LinkedList<String>();
        accumulator.add("");
        for(int i = 0; i < xs.length(); i++){
            String prefix = xs.substring(i,i+1);
            String rest = xs.substring(i+1);
            accumulator.addAll(combinationHelper(rest)
                    .stream()
                    .map(x -> prefix + x )
                    .collect(Collectors.toList())
            );
        }
        return accumulator;
    }

    // "prefix", "rest"
    // generate all possible subsets
    public static void getAllCombinations(String input){
        combinationHelper(input).stream().forEach(x-> System.out.println("-->" + x + "<--"));
    }







    public static void main(String ... args){
        /*
        System.out.println(rotateString("abcd",1));
        System.out.println(rotateString("abcd",2));
        System.out.println(rotateString("abcd",3));
        System.out.println(rotateString("abcd",4));
        System.out.println(rotateString("abcd",5));
        System.out.println(rotateString("abcd",6));
        System.out.println(rotateString("",6));
        */
        //getAllPermutations("abcd").forEach(System.out::println);
        getAllCombinations("abcd");
    }
}
