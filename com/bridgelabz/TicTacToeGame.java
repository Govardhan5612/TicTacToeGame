package com.bridgelabz;

import java.util.Scanner;

/**
 * @author Govardhan Reddy
 */
public class TicTacToeGame {
    /**
     * create a tic tac toe game board programming
     */
    static char[] board = new char[10];
    static char playerLetter;
    static char computerLetter;

    public static void main(String[] args) {
        whoWillWin();
        Scanner input = new Scanner(System.in);
        System.out.println("1. Play again   2. Stop the play");
        System.out.print("Enter number : ");
        int number = input.nextInt();
        /**
         * call game again
         */
        if (number == 1) {
            whoWillWin();
        } else {

        }
    }

    public static void whoWillWin() {
        board();
        chooseLetter();
        System.out.println("Player letter : " + playerLetter);
        System.out.println("Computer letter : " + computerLetter);
        boolean winToss = whoPlayFirst();
        if (winToss == true) {
            System.out.println("Player won the toss");
        } else {
            System.out.println("Computer won the toss");
        }
        while (true) {

            if (winToss == true) {
                checkFreeSpace();
                desireMove();
                printBoard();
                winner();
                checkFreeSpace();
                computerTurn();
                printBoard();
                winner();
                if (winner() == 1) {
                    System.out.println("Player is win the game");
                    break;
                } else if (winner() == 2) {
                    System.out.println("Computer is win the game");
                    break;
                } else if (winner() == 3) {
                    System.out.println("Match is draw and board is full");
                    break;
                }
            } else {
                checkFreeSpace();
                computerTurn();
                printBoard();
                winner();
                if (winner() == 1) {
                    System.out.println("Player is win the game");
                    break;
                } else if (winner() == 2) {
                    System.out.println("Computer is win the game");
                    break;
                } else if (winner() == 3) {
                    System.out.println("Match is draw and board is full");
                    break;
                }
                checkFreeSpace();
                desireMove();
                printBoard();
                winner();
            }
        }
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
        int number;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Player number (1-9) : ");
            number = input.nextInt();
            if (board[number] == ' ') {
                break;
            }
        }
        System.out.println("Player Number : " + number);
        board[number] = playerLetter;
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
        /**
         * random method used to find who play first
         */
        int toss = (int) ((Math.random() * 10) % 2);
        if (toss == 1) {
            return true;

        } else {
            return false;
        }
    }

    public static int winner() {
        /**
         * find the winner is player or computer
         */
        if ((board[1] == playerLetter && board[2] == playerLetter && board[3] == playerLetter) ||
                (board[4] == playerLetter && board[5] == playerLetter && board[6] == playerLetter) ||
                (board[7] == playerLetter && board[8] == playerLetter && board[9] == playerLetter) ||
                (board[1] == playerLetter && board[4] == playerLetter && board[7] == playerLetter) ||
                (board[2] == playerLetter && board[5] == playerLetter && board[8] == playerLetter) ||
                (board[3] == playerLetter && board[5] == playerLetter && board[9] == playerLetter) ||
                (board[1] == playerLetter && board[5] == playerLetter && board[9] == playerLetter) ||
                (board[3] == playerLetter && board[5] == playerLetter && board[7] == playerLetter)) {
            return 1;
        } else if ((board[1] == computerLetter && board[2] == computerLetter && board[3] == computerLetter) ||
                (board[4] == computerLetter && board[5] == computerLetter && board[6] == computerLetter) ||
                (board[7] == computerLetter && board[8] == computerLetter && board[9] == computerLetter) ||
                (board[1] == computerLetter && board[4] == computerLetter && board[7] == computerLetter) ||
                (board[2] == computerLetter && board[5] == computerLetter && board[8] == computerLetter) ||
                (board[3] == computerLetter && board[6] == computerLetter && board[9] == computerLetter) ||
                (board[1] == computerLetter && board[5] == computerLetter && board[9] == computerLetter) ||
                (board[3] == computerLetter && board[5] == computerLetter && board[7] == computerLetter)) {
            return 2;
            /**
             * if board is full show the message is game is drawn
             */
        } else if (board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' ' && board[5] != ' ' && board[6] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ') {
            return 3;
        } else {
            return 4;
        }
    }

    public static void computerTurn() {
        /**
         * in computer turn take random values in between 1 to 9
         */
        int computerNumber;
        while (true) {
            computerNumber = (int) ((Math.random() * 10) % 9 + 1);
            int duplicateNumber = 0;
            /**
             * take choice to center
             */
            if (board[5] == ' ') {
                duplicateNumber = 5;
            }
            /**
             * take first choice is corners
             */
            else if (board[1] == ' ') {
                duplicateNumber = 1;
            } else if (board[3] == ' ') {
                duplicateNumber = 3;
            } else if (board[7] == ' ') {
                duplicateNumber = 7;
            } else if (board[9] == ' ') {
                duplicateNumber = 9;
            }
            /**
             * Computer block the player
             */
            else if ((board[2] == playerLetter && board[3] == playerLetter) || (board[5] == playerLetter && board[9] == playerLetter) || (board[4] == playerLetter && board[7] == playerLetter)) {
                duplicateNumber = 1;
            } else if ((board[1] == playerLetter && board[3] == playerLetter) || (board[5] == playerLetter && board[8] == playerLetter)) {
                duplicateNumber = 2;
            } else if ((board[1] == playerLetter && board[2] == playerLetter) || (board[5] == playerLetter && board[7] == playerLetter) || (board[6] == playerLetter && board[9] == playerLetter)) {
                duplicateNumber = 3;
            } else if ((board[1] == playerLetter && board[7] == playerLetter) || (board[5] == playerLetter && board[6] == playerLetter)) {
                duplicateNumber = 4;
            } else if ((board[1] == playerLetter && board[9] == playerLetter) || (board[3] == playerLetter && board[7] == playerLetter) || (board[2] == playerLetter && board[8] == playerLetter) || (board[4] == playerLetter && board[6] == playerLetter)) {
                duplicateNumber = 5;
            } else if ((board[4] == playerLetter && board[5] == playerLetter) || (board[3] == playerLetter && board[9] == playerLetter)) {
                duplicateNumber = 6;
            } else if ((board[8] == playerLetter && board[9] == playerLetter) || (board[3] == playerLetter && board[5] == playerLetter) || (board[1] == playerLetter && board[4] == playerLetter)) {
                duplicateNumber = 7;
            } else if ((board[7] == playerLetter && board[9] == playerLetter) || (board[2] == playerLetter && board[5] == playerLetter)) {
                duplicateNumber = 8;
            } else if ((board[7] == playerLetter && board[8] == playerLetter) || (board[3] == playerLetter && board[6] == playerLetter) || (board[1] == playerLetter && board[5] == playerLetter)) {
                duplicateNumber = 9;
            }

            if (board[duplicateNumber] == ' ') {
                computerNumber = duplicateNumber;
                break;
                /**
                 * take random value use random method
                 */
            } else if (board[computerNumber] == ' ') {
                break;
            }
        }
        System.out.println("Computer Number : " + computerNumber);
        board[computerNumber] = computerLetter;

    }
}
