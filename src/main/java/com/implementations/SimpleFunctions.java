package com.implementations;

/**
 * Created by aragipindi on 4/7/15.
 */
public class SimpleFunctions {

    public class MySimpleInnerClass{
        public void print(){
            System.out.println("Hello World!");
        }
    }
    static class B {}
   



    public static String padZeroes(String a,int length){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i < length;i++){
            builder.append("0");
        }
        builder.append(a);
        return builder.toString();
    }

    public static String addBinaryStrings(String a,String b){
        int carryForward = 0;
        int maxLength = Math.max(a.length(),b.length());
        String aNew = padZeroes(a,maxLength-a.length());
        String bNew = padZeroes(b,maxLength-b.length());
        StringBuilder builder = new StringBuilder();
        for(int i = maxLength-1; i >=0;i--){
            int a_i = aNew.charAt(i) - '0';
            int b_i = bNew.charAt(i) - '0';
            int sum = a_i + b_i + carryForward;
            if(sum ==3){
                builder.append("1");
                carryForward = 1;
            }else if(sum == 2){
                builder.append("0");
                carryForward = 1;
            }else if(sum == 1){
                builder.append("1");
                carryForward = 0;
            }else{
                builder.append("0");
                carryForward = 0;
            }
        }
        if(carryForward == 1){
            builder.append("1");
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(addBinaryStrings("1100","1111"));
        SimpleFunctions jj = new SimpleFunctions();
        SimpleFunctions.MySimpleInnerClass jm = jj.new MySimpleInnerClass();
    }
}
