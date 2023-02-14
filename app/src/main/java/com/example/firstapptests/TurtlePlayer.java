package com.example.firstapptests;

public class TurtlePlayer extends Player{

    private final char difficulty = 'H';
    private int lives;

    public TurtlePlayer(String playerName) {
        super(playerName);
        this.lives = 3;
    }

    public int getLives() {
        return lives;
    }

    public char getDifficulty() {
        return difficulty;
    }
}

