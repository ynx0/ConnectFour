package com.lux.util;

import com.lux.main.Player;

import java.util.Scanner;

public class Game {


    Scanner scanner = new Scanner(System.in);
    String userInput = "";


    public int[][] board = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    // length
    final int BOARD_HEIGHT = board.length - 1; //lol
    final int BOARD_LENGHT = board[0].length - 1;

    public static final int empty = 0;
    public static final int playerOne = 1;
    public static final int playerTwo = 2;


    public boolean hasPlayerWon = false;
    Player currentPlayer = Player.ONE; // Player One always starts first



    public void run() {
        // someone has won
        Player winningPlayer = WinCondition.checkForWin(board);
        if(winningPlayer != null) {
            System.out.println(winningPlayer + " has won");
            hasPlayerWon = true;
        }
        drawBoard();
        waitForPlayerInput();

        swapTurn();
    }

    void drawBoard() {


        System.out.println(" -----------------------------------------");
        for (int i = 0; i <= BOARD_HEIGHT; i++) {  //height
            for (int j = 0; j <= BOARD_LENGHT; j++) { //length
                System.out.print(" | " + getTokenSymbol(board[i][j]));
            }
            System.out.print("|");
            System.out.println("\n");
        }
        System.out.println("\b -----------------------------------------");
    }


    void printGameOptions() {
        System.out.println(currentPlayer + "'s Turn");
        System.out.println("Choose a column to drop a token in:");
    }

    void waitForPlayerInput() {
        printGameOptions();
        userInput = scanner.nextLine();
        int columnNum = 0;
        try {
            columnNum = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            run(); // maybe hacky way to go back to start of run
        }

        dropToken(columnNum-1);
    }

    void swapTurn() {
        currentPlayer = Player.opposite(currentPlayer);
    }

    char getTokenSymbol(int token){
        char playerEmpty = ' ';
        char playerOneSymbol = 'x';
        char playerTwoSymbol = 'o';

        if (token == 2){
            return playerTwoSymbol;
        } else if (token == 1) {
            return playerOneSymbol;
        } else {
            return playerEmpty;
        }
    }

    void dropToken(int columnNum) {
        boolean dropped = false;
        //input sanitation
        if (columnNum < 0) columnNum = 0;
        if (columnNum > BOARD_LENGHT) columnNum = BOARD_LENGHT;

        System.out.println(columnNum);
        for (int i = BOARD_HEIGHT; i >= 0; i--) { //start from bottom of array and choose non-filled spot
            if(board[i][columnNum] == 0 ) {
                board[i][columnNum] = currentPlayer.getPlayerNum();
                dropped = true;
                break;
            }
        }

        if (!dropped) {
            System.out.println("That column is already full bro");
        }

    }



}
