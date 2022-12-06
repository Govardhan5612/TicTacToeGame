package com.bridgelabz;

import java.util.Scanner;

/**
 * @author Govardhan Reddy
 */
public class TicTacTieGame {
    /**
     * create a tic tac toe game board programming
     */
    static char[] board = new char[10];
    static char playerLetter;
    static char computerLetter;

    public static void main(String[] args) {
        printBoard();
        chooseLetter();

    }

    public static void printBoard() {
        /**
         * create a single empty space in board
         */
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    public static void chooseLetter() {
        /**
         * choose letter from console
         */
        Scanner input = new Scanner(System.in);
        System.out.print("Choose letter X or O : ");
        playerLetter = input.next().charAt(0);
        if (playerLetter == 'X') {
            computerLetter = 'O';
            playerLetter = 'X';
        } else {
            computerLetter = 'X';
            playerLetter = 'O';
        }
    }
}
