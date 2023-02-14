package com.example.firstapptests;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.content.res.Resources;

import androidx.core.content.res.ResourcesCompat;

public class DoriPlayer extends Player{

    private final char difficulty =  'M';
    private int lives;
    Drawable doriSprite;

    public DoriPlayer(String playerName, Resources res) {
        super(playerName);
        this.lives = 5;
        doriSprite = ResourcesCompat.getDrawable(res, R.drawable.doripixel, null);
    }



    public int getLives() {
        return lives;
    }

    public char getDifficulty() {
        return difficulty;
    }

    public Drawable getDoriSprite() {
        return doriSprite;
    }
}
