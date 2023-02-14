package com.example.firstapptests;

import java.util.Locale;

public class Player{

    private String playerName;
    private int score;

    // Players should not be allowed to pass in a null, empty, or whitespace-only name.
    public Player(String playerName) {
        if (playerName == null || playerName.isEmpty() || playerName.trim().length() == 0) {
            throw new IllegalArgumentException("Enter a valid Player Name");
        }
        this.playerName = playerName;
        this.score = 0;
    }


    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }

}
