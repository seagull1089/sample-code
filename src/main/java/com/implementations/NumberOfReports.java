package com.implementations;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aragipindi on 4/9/15.
 */
public class NumberOfReports {
    public static Map<String,Integer> getNumberOfReportsForEachEmployee(Map<String,String> reportsTo){
        Map<String,Integer> counts = new HashMap<String,Integer>();
        for(String s: reportsTo.keySet()){
            String tmp = s;
            if(!counts.containsKey(s)) counts.put(s,0);
            while(reportsTo.containsKey(tmp) && !reportsTo.get(tmp).equals(tmp)){
                String manager = reportsTo.get(tmp);
                counts.put(manager,counts.getOrDefault(manager,0) +1);
                tmp = manager;
            }
        }
        return counts;
    }
    public static void main(String[] args){
        Map<String,String> reportsTo = new HashMap(){{
            put("a","c");
            put("b","c");
            put("c","f");
            put("d","e");
            put("e","f");
            put("f","f");
        }};

        Map<String,Integer> counts = getNumberOfReportsForEachEmployee(reportsTo);
        for(String k: counts.keySet()){
            System.out.println(k + " -- " + counts.get(k));
        }
    }

}
