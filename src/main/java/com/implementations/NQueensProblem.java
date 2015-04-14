package com.implementations;


/**
 * Created by aragipindi on 4/9/15.
 * Naive implementation of NQueens problem.
 */
public class NQueensProblem {

    /**
     *
     * @param board
     * @param row
     * @param col
     * @return checks if the given row and column are safe to put the queen or not.
     * Checks the row, column and diagonals of the given position.
     */
    public static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (i != col && board[row][i] == 1) {
                return false;
            }
            if (i != row && board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row + 1, j = col - 1; i < board.length && j > 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row + 1, j = col + 1; i < board.length && j < board.length; i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }


    public static int solve(int[][] board, int q) {
        if (q >= board.length) {
            return 1;
        }

        int count = 0;
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, q, j)) {
                //System.out.println("safe" + q + "," + j);
                board[q][j] = 1;
                count += solve(board, q + 1);
                board[q][j] = 0;

            }
        }
        return count;
    }

    public static int solve(int[][] board) {
        return solve(board, 0);
    }

    public static void main(String[] args) {
        int N = 10;
        int[][] myarray = new int[N][N];
        System.out.println(solve(myarray));
        /*
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(myarray[i][j] + " ");
            }
            System.out.println();
        }
        */
    }
}
