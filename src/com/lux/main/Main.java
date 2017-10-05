package com.lux.main;

import com.lux.ai.AI;
import com.lux.util.Game;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        //AI ai = new AI();

        while (!game.hasPlayerWon) {
            game.run();
//            ai.run();
        }
    }



}
