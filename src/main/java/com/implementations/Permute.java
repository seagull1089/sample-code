package com.implementations;

import java.util.Arrays;

/**
 * Created by aragipindi on 5/14/15.
 */
public class Permute {

    public static void swap(char[] s,int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
    public static void permute(char[] s,int index){
        if(index >= s.length){
            System.out.println(new String(s));
            return;
        }
        permute(s,index+1);
        for(int i = index; i < s.length; i++){
            if(s[i]<=s[index]){ continue;}
            swap(s,i,index);
            permute(s,index+1);
            swap(s,i,index);
        }
    }

    public static void main(String[] args){
        char[] s = "aab".toCharArray();
        Arrays.sort(s);
        permute(s, 0);
    }
}
