package com.implementations;


/**
 * Created by aragipindi on 4/9/15.
 */
public class NQueensProblem {

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


    public static boolean solve(int[][] board, int q) {
        if (q >= board.length) {
            return true;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, q, j)) {
                //System.out.println("safe" + q + "," + j);
                board[q][j] = 1;
                boolean solved = solve(board, q + 1);
                if (!solved) {
                    board[q][j] = 0;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void solve(int[][] board) {
        solve(board, 0);
    }

    public static void main(String[] args) {
        int N = 16;
        int[][] myarray = new int[N][N];
        solve(myarray);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(myarray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
