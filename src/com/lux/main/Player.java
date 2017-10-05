package com.lux.main;

import org.jetbrains.annotations.Contract;

public enum Player {
    ONE(1), TWO(2);

    private int playerNum;

    Player(int playerNum){
        this.playerNum = playerNum;
    }

    @Override
    public String toString(){
        return "Player " + getPlayerNum();
    }

    @Contract(pure = true)
    public int getPlayerNum(){
        return this.playerNum;
    }

    @Contract(pure = true)
    public static Player opposite(Player player) {
        if(player == Player.ONE) {
            return Player.TWO;
        } else {
            return Player.ONE;
        }
    }
}
