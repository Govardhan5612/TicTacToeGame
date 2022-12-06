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
        board();
        chooseLetter();
        System.out.println("Player letter : " + playerLetter);
        System.out.println("Computer letter : " + computerLetter);
        printBoard();
        desireMove();
    }

    public static void board() {
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

    public static void printBoard() {
        /**
         * printing the board while playing the game
         */
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("----------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("----------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
        System.out.println("----------");
    }

    public static void desireMove() {
        /**
         * select the desire location in board
         */
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your location (1-9) : ");
        int number = input.nextInt();
        if (number < 1 && number > 9) {
            System.out.println("Enter number in between (1 to 9)");
            checkFreeSpace();
            desireMove();
        } else if (board[number] != ' ') {
            System.out.println("Already fill this box select new location");
            chooseLetter();
            desireMove();
        } else {
            board[number] = playerLetter;
            printBoard();
            checkFreeSpace();
            desireMove();
        }
    }

    public static void checkFreeSpace() {
        /**
         * check the number of boxes are available
         */
        boolean freeSpace = false;
        int numberOfSpaces = 0;
        for (int i = 1; i < board.length; i++) {
            if (board[i] == ' ') {
                freeSpace = true;
                numberOfSpaces++;
            }
        }
        if (freeSpace == false) {
            System.out.println("Board is full");
        } else {
            System.out.println(numberOfSpaces + " boxes are available");
        }
    }

    public static boolean whoPlayFirst() {
        int toss = (int) ((Math.random() * 10) % 2);
        if (toss == 1) {
            return true;
        } else {
            return false;
        }
    }
}
