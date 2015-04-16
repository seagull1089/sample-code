package com.implementations;

/**
 * Created by aragipindi on 4/16/15.
 */
public class NumberOfPossiblePasswords {

    public static int getTotalNumberOfValidSolutions(int[][] touchpad){
        int numSolutions = 0;
        int numRows  = touchpad.length;
        int numCols = 0;
        if(numRows > 0){
            numCols = touchpad[0].length;
        }
        int[][] emptyTouchPad = new int[numRows][numCols];

        for(int i = 0 ; i <numRows; i++){
            for(int j = 0; j <numCols; j++){
                int current =  getTotalNumberOfValidSolutions(emptyTouchPad,i,j,numRows,numCols);
                //System.out.println("with " +  getDigit(i,j,numRows) + " :" + current );
                numSolutions += current;
            }
        }
        return numSolutions;
    }

    public static int getDigit(int row,int col,int numRows){
        return (row)*numRows + (col +1);
    }


    public static int getTotalNumberOfValidSolutions(int[][] touchpad,int row,int col,int numRows,int numCols){

        if(touchpad[row][col] == 1){
            return 0;
        }
        touchpad[row][col] = 1;
        // (0,0) = 1
        // row,col → explore what positions are open in the possible directions.
        int numSolutions = 1;
        if(row < numRows-1 ){
            //
            numSolutions +=  getTotalNumberOfValidSolutions(touchpad,row+1,col,numRows,numCols) ; // explore (0,0) (1,0) onwards  → 14  ...
        }
        if(col <numCols-1){

            numSolutions +=  getTotalNumberOfValidSolutions(touchpad,row,col+1,numRows,numCols) ;
        // 12..
        }
        if(col > 0) {
            numSolutions +=  getTotalNumberOfValidSolutions(touchpad,row,col-1,numRows,numCols) ;
        }
        if(row > 0){
            numSolutions +=  getTotalNumberOfValidSolutions(touchpad,row-1,col,numRows,numCols) ;

        }

        // diagonal conditions
        if(row < touchpad.length-1 && col < touchpad.length-1){
            numSolutions += getTotalNumberOfValidSolutions(touchpad,row+1,col+1,numRows,numCols) ;
        }
        if(row < touchpad.length-1 && col > 0 ){
            numSolutions += getTotalNumberOfValidSolutions(touchpad,row+1,col-1,numRows,numCols) ;
        }
        if(row > 0 && col > 0 ){
            numSolutions += getTotalNumberOfValidSolutions(touchpad,row- 1,col-1,numRows,numCols) ;
        }
        if(row > 0 && col < touchpad.length-1){
            numSolutions += getTotalNumberOfValidSolutions(touchpad,row-1,col+1,numRows,numCols) ;
        }

// similarly when it is possible to explore in (row-1,col-1), (row+1,col-1), (row-1,col+1)


        touchpad[row][col] = 0;

        return numSolutions;
    } // end of the method.


    public static void main(String[] args){
        int[][] touchpad = {
                {1,2,3},{4,5,6},{7,8,9}
        };
        System.out.println(getTotalNumberOfValidSolutions(touchpad));
    }

}


/**
 -- by the fruit company. --
 On a smartphone, you are given a touchpad similar to below for entering password:

 1  |  2  |  3
 -------------
 4  |  5  |  6
 -------------
 7  |  8  |  9

 passwords are created by continuously swiping your finger over the touchscreen keyboard.

 Write a program to return the total number of passwords that are possible.

 The constraints are:
 The passwords can be from 1 to 9 character long
 You can move along any direction, including diagonal
 While swiping, the finger can not be lifted. So, 123 is a valid password. 13 is invalid.
 The same character can not be repeated. So, 123 is a valid password. 121 is invalid.

 **/
