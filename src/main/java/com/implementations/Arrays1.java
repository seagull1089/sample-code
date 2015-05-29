package com.implementations;
import java.util.Arrays.*;

/**
 * Created by aragipindi on 5/21/15.
 * saisreerama.
 */

public class Arrays1 {
    public static void swap(int [] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static int[] moveAllZeroesToLast(int[] numbers){
        int storeIndex = numbers.length;
        while(storeIndex > 0 && numbers[--storeIndex] == 0);
        int index = 0;
        while(storeIndex > index){
            if(numbers[index] == 0){
                swap(numbers,index,storeIndex);
                storeIndex--;
            }
            index++;
        }
        return numbers;
    }


    public static void getNumbersOfSum(int[] arr,int sum, int excludeIndex){
        if(arr.length < 2){
            return;
        }
        int last = arr.length -1;
        int start = 0;
        while(last > start){
            if(start == excludeIndex){
                start++;
            } else if(last == excludeIndex){
                last--;
            }else{
                int currentSum = arr[last] + arr[start];
                if(currentSum == sum ){
                    System.out.println(arr[excludeIndex] + " " + arr[start] + " " + arr[last]);
                    return;
                }else if(currentSum > sum){
                    last--;
                }else {
                    start++;
                }
            }
        }
    }

    public static void get3NumbersOfSum(int[] arr,int sum){
        for(int i = 0; i < arr.length;i++){
            getNumbersOfSum(arr,(sum -arr[i]),i);
        }
    }


    public static int findInRotatedArray(int [] arr,int left,int right, int elem){
       if(right< left){
           return -1;
       }
        int mid = (left + right)/2;
        if(elem == arr[mid]){
            return mid;
        }else if(arr[left] < arr[mid]){
            if(elem >= arr[left] && elem <= arr[mid]){
                return findInRotatedArray(arr,left,mid-1,elem);
            }else{
                return findInRotatedArray(arr,mid+1,right,elem);

            }

        }else if(arr[left] > arr[mid]){
            if(elem >=arr[mid] && elem <= arr[right]){
                return findInRotatedArray(arr,mid+1,right,elem);

            }else{
                return findInRotatedArray(arr,left,mid-1,elem);

            }

        }else if(arr[left] == arr[mid]){
            if(arr[mid] !=  arr[right]){
                return findInRotatedArray(arr,mid+1,right,elem);
            }else{
                int index = findInRotatedArray(arr,mid+1,right,elem);
                if(index == -1){
                    return findInRotatedArray(arr,left,mid-1,elem);
                }else{
                    return index;
                }
            }

        }
        return -1;
    }


    public static void main(String[] args){

        /*
        System.out.println(java.util.Arrays.toString(moveAllZeroesToLast(new int[]{ 0,1,2,3,4,5,0,0})));
        System.out.println(java.util.Arrays.toString(moveAllZeroesToLast(new int[]{ 0,1,2,3,4,5})));
        System.out.println(java.util.Arrays.toString(moveAllZeroesToLast(new int[]{ 0})));
        System.out.println(java.util.Arrays.toString(moveAllZeroesToLast(new int[]{ 1})));
        System.out.println("Hello World 4");
        get3NumbersOfSum(new int[]{1, 2, 4, 7, 11, 15},13);

*/
        int[] arr = new int[]{8,9,0,1,2,3,4,5,6};
        for(int  i = 0; i < 12; i++){
            System.out.println("found " + i + " at " + findInRotatedArray(arr,0, arr.length -1, i));
        }

        arr = new int[]{ 1,1,1,1,1,1,1,4,1,1};
        System.out.println("found " + 4 + " at " + findInRotatedArray(arr,0, arr.length -1, 4));
        System.out.println("found " + 1 + " at " + findInRotatedArray(arr,0, arr.length -1, 1));
    }

}
