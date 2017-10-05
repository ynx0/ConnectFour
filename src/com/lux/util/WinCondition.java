package com.lux.util;

import com.lux.main.Player;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.jetbrains.annotations.Nullable;

public class WinCondition {

    @Nullable
    public static Player checkForWin(int[][] board) {

        boolean hasOneWon = false;
        boolean hasTwoWon = false;


        CircularFifoQueue four = new CircularFifoQueue(4);

        // horizontal check
        for (int[] row : board) {
            if(hasOneWon || hasTwoWon) break;
            for (int token : row) {
                four.add(token);
                hasOneWon = four.stream().allMatch(o -> (int) o == 1); // if all are 1
                if (hasOneWon) break; // need this so that it doesn't keep searching and set to false again
                hasTwoWon = four.stream().allMatch(o -> (int) o == 2); // if all are 2
                if (hasTwoWon) break;
            }
        }
        // flush previous values
        four.clear();

        //vertical check
        for (int i = 0; i < board[0].length; i++) {
            if(hasOneWon || hasTwoWon) break;
            for (int j = 0; j < board.length; j++) {
                four.add(board[j][i]);
                hasOneWon = four.stream().allMatch(o -> (int) o == 1);
                if (hasOneWon) break;
                hasTwoWon = four.stream().allMatch(o -> (int) o == 2);
                if (hasTwoWon) break;
            }
        }

        //todo diagonal check

        if (hasOneWon){
            return Player.ONE;
        } else if (hasTwoWon){
            return Player.TWO;
        } else {
            return null;
        }

    }



}
/*
 for (int[] row : board) {
            for (int j = 0; j < BOARD_LENGHT; j++) {
                fourCheck.add(row[j]);
                System.out.println("fourcheck: \n" + fourCheck);
                //System.out.println(playerOneWin);
                //System.out.println(playerTwoWin);
                if (fourCheck.(playerOneWin)){
                    winningPlayerNum = 1;
                    break;
                } else if (fourCheck.containsAll(playerTwoWin)){
                    winningPlayerNum = 2;
                    break;
                }
            }
        }

        // now we check diagonally from left to right
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            fourCheck.add(board[i][i]);
            System.out.println(fourCheck);
            if (fourCheck.containsAll(playerOneWin)){
                winningPlayerNum = 1;
            } else if (fourCheck.containsAll(playerTwoWin)){
                winningPlayerNum = 2;
            }
        }
        //todo check diagonal right to left
 */


// [0] \\
/*
int num = (int) o;
if (num == 1){
                        return true;
                    }
                    */