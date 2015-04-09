package com.implementations;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by aragipindi on 3/24/15.
 */
public final class CodeForces {
    private static void println(Object o){
        System.out.println(o);
    }

    // http://codeforces.com/problemset/problem/527/B
    public static void getMinErrorCode(String input,String correct){
        List<Integer> allMismatches = new LinkedList<>();
        for(int i = 0; i < input.length() ; i ++ ){
            if(input.charAt(i) != correct.charAt(i)){
                allMismatches.add(i);
            }
        }
        int minErrors = allMismatches.size();
        //System.out.println(allMismatches.stream().map(x -> x.toString()).collect(Collectors.joining(",")));
        int bestGain  = 0;
        int best_i = -1;
        int best_j = -1;
        for(int i= 0; i < allMismatches.size(); i++){
            for(int j = i+1; j < allMismatches.size(); j++){

                int maxPossibleGain = 0;
                if(input.charAt(allMismatches.get(i)) == correct.charAt(allMismatches.get(j))){
                    maxPossibleGain++;
                }
                if(input.charAt(allMismatches.get(j)) == correct.charAt(allMismatches.get(i))){
                    maxPossibleGain++;
                }
                if(maxPossibleGain > bestGain){
                    bestGain  = maxPossibleGain;
                    best_i = allMismatches.get(i) +1 ;
                    best_j = allMismatches.get(j) + 1;
                }
            }
        }
        System.out.println(minErrors - bestGain);
        System.out.println(best_i + " " + best_j);
    }


    // A -> {B,C,D}
    // B -> { E, F}
    public static int getMaxDepth(Map<String,List<String>> graph,String name){

        if(!graph.containsKey(name) || graph.get(name) == null || graph.get(name).size() == 0){
            return 1;
        }else{
            int maxDepth = 0;
            for(String child:graph.get(name)){
                int currDepth =  getMaxDepth(graph,child) +1;
                if(currDepth > maxDepth){
                    maxDepth = currDepth;
                }
            }
            println("name:" + name + "\t" + maxDepth);
            return maxDepth;
        }
    }

    public static void main(String ... args){
        //getMinErrorCode("pergament","permanent");
        //getMinErrorCode("wookie","cookie");
        //getMinErrorCode("petr","egotr");
        println(getMaxDepth(new HashMap<String, List<String>>() {{
                                put("1", Arrays.asList("2", "3", "4"));
                                put("2", Arrays.asList("5", "6"));
                                put("6", Arrays.asList("7"));
                    }},"1"
        ));

    }


}
