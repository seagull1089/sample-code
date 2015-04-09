package com.implementations;

/**
 * Created by aragipindi on 4/4/15.
 */
public class MedianOfSortedArrays {

    public double findMedianOfSortedArrays(double[] A,double[] B){
        int i=0, j=0;
        while(i < A.length && j < B.length){
            double a = A[i];
            double b = B[j];
            if(i+j == (A.length + B.length)/2) {
                return (a +b)/2;
            }else if( a < b){
                i++;
            }else if(b < a){
                j++;
            }else{
                i++;
                j++;
            }
        }
        return -1.0d;
    }

    public static int getMaximumElementIndexInRotatedArray1(int[] array){
        int left = 0;
        int right = array.length-1;


        int maxIndex = right;
        while(left < right){
            //System.out.println("--" + mid);
            int mid =  (left + right)/2;
            int currentMax = array[mid];

            System.out.println("\t" + currentMax);
            if(array[left] > currentMax){
                right = mid-1;
                maxIndex = left;
            }else if(array[right] < currentMax){
                left = mid;
                right = right -1;
                maxIndex = mid;
            }else{
                break;
            }
            //System.out.println("left:" +  left + " right: " + right);

        }
        return array[maxIndex];
    }

    public static int getMaximumElementIndexInRotatedArray(int[] array){
        int left = 0;
        int right = array.length -1;
        int maxIndex = right;
        while(left < right){
            if(array[left] == array[right]){
                left++;
                right--;
            }else if(array[left] > array[right]) {
                maxIndex = left;
                right = (right +left)/2;
            }else{
                maxIndex = right;
                left = (right + left)/2;
            }
        }
        return Math.max(array[left],array[right]);
    }


    public static boolean findTargetInRotatedArray(int[] A,int target){
        // assume the array is sorted in ascending order.
        // (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
        int mid = A.length/2;


        return false;
    }

    public static void main(String[] args){
        System.out.println(getMaximumElementIndexInRotatedArray(new int[]{5, 6, 7, 8, 9, 0, 1, 2}));
        System.out.println(getMaximumElementIndexInRotatedArray(new int []{5,6,7,8,9,0,1,2,3}));
        System.out.println(getMaximumElementIndexInRotatedArray(new int []{0,1,2}));
        System.out.println(getMaximumElementIndexInRotatedArray(new int []{2,0,1}));
        System.out.println(getMaximumElementIndexInRotatedArray(new int []{1,2,0}));
        System.out.println(getMaximumElementIndexInRotatedArray(new int []{1,2}));
        System.out.println(getMaximumElementIndexInRotatedArray(new int []{2,1}));
        System.out.println(getMaximumElementIndexInRotatedArray(new int []{2,1,1,1,1,1,1,1,1}));
        System.out.println(getMaximumElementIndexInRotatedArray(new int []{1,1,1,1,1,1,2,1}));
        System.out.println(getMaximumElementIndexInRotatedArray(new int []{1,1,2,1}));
    }
}
