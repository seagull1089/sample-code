package com.implementations;

import java.util.*;
import java.util.Arrays;

/**
 * Created by aragipindi on 4/1/15.
 */
    public class BinarySearch {

    public static int findTarget(int[] A, int target){
        int lo = 0;
        int hi = A.length;
        int mid = -1;
        mid = (hi + lo)/2;
        while(lo <= hi && mid < A.length ){

            if( target == A[mid]){
                System.out.println("Index: " + mid);
                return mid;

            }else if(target < A[ mid]){
                hi = mid -1;
            }else{
                lo = mid+1;
            }
            mid = (lo + hi)/2;
        }

        return -(mid) -1;
    }


    public static void quickSort(int[] a){

        quickSort(a,0,a.length-1);
    }

    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    // this is one of the methods to know by heart.
    public static int partition(int[] a,int left,int right){
        int pivotIndex = (right + left)/2;
        int pivot = a[pivotIndex];
        swap(a, pivotIndex, right);
        int smallerValuesIndex = left;
        for(int i=left; i < right; i++){
            if(a[i] < pivot){
                swap(a,i,smallerValuesIndex);
                smallerValuesIndex++;
            }
        }
        swap(a,smallerValuesIndex,right);
        return smallerValuesIndex;
    }
    public static void quickSort(int[] a,int left,int right){
        // these are strict.
        if(left >= right || left < 0 || right > a.length-1){
            return;
        }
        int pivot = partition(a,left,right);
        System.out.println(pivot);
        quickSort(a,left,pivot-1);
        quickSort(a, pivot + 1, right);
    }


    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    public static void rotate2(int[][] matrix){
        int n = matrix.length;
      //  int[][] copy = new int[n][n];
        // (i,j) --> (j,n-i-1)--> (n-i-1,j) -> (i,j)
        for(int i = 0; i < n/2; i++){
            for(int j=0;j < (n+1)/2; j++){
                    int tmp = matrix[j][n-i-1];
                    matrix[j][n-1-i] = matrix[i][j];
                    int tmp2 = matrix[n-1-j][i];
                    matrix[n-1-i][j] = tmp;
                    matrix[i][j] = tmp2;
            }
        }


    }

    public List<String> generateParenthesis2(int n) {
        if (n < 1) {
            return java.util.Arrays.asList("");
        } else if (n == 1) {
            return java.util.Arrays.asList("()");
        } else {
            Set<String> set = new HashSet<>(n * 2);
            for (String s : generateParenthesis2(n - 1)) {
                char[] ca = s.toCharArray();
                int len = s.length();
                for (int i = 0; i < len; i++) {
                    set.add(String.copyValueOf(ca, 0, i) + "()"
                            + String.copyValueOf(ca, i, len - i));
                }
            }
            return new ArrayList<String>(set);
        }
    }

    public static void generateParantheses(int left,int right,String s){
        if(left == 0 && right == 0){
            System.out.println(s);
        }
        if(left > 0){
            generateParantheses(left-1,right+1,s + "(");
        }
        if(right > 0){
            generateParantheses(left,right-1, s+ ")");
        }
    }

    public static void main(String[] args){
        /*
        int[] array = new int[]{5,5,5,5,5,5,5,7,7,7,7};
        System.out.println(findTarget(array, 5));
        System.out.println(Arrays.binarySearch(array, 8));
        System.out.println(findTarget(array, 8));

        int[] unsortedArray = new int[]{9,8,7,4,10,4,3};
        quickSort(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
        unsortedArray = new int[]{4,5,4,6,7,6};
        quickSort(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
        */

        /*
        int[][] array = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate2(array);
        for(int[] x: array){
            System.out.println(Arrays.toString(x));
        }*/
        generateParantheses(4,0,"");

    }
}
