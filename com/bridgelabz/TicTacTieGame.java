package com.bridgelabz;

/**
 * @author Govardhan Reddy
 */
public class TicTacTieGame {
    /**
     * create a tic tac toe game board programming
     */
    static char [] board = new char[10];

    public static void main(String[] args) {
        printBoard();

    }
    public static void printBoard(){
        /**
         * create a single empty space in board
         */
        for (int i = 1;i< board.length;i++){
            board[i]=' ';
        }
        System.out.println(board[1]+" | "+board[2]+" | "+board[3]);
        System.out.println(board[4]+" | "+board[5]+" | "+board[6]);
        System.out.println(board[7]+" | "+board[8]+" | "+board[9]);
    }
}
